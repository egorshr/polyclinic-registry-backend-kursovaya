package com.example.routing

import com.example.data.user.*
import com.example.security.hashing.HashingService
import com.example.security.token.TokenClaim
import com.example.security.token.TokenConfig
import com.example.security.token.TokenService
import com.example.util.Role
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.signUp(
    hashingService: HashingService,
    userDataSource: UserDataSource
) {
    post("signup") {
        val request = call.receiveNullable<AuthRequest>() ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        val areFieldsBlank = request.email.isBlank() || request.password.isBlank()
        val isPasswordTooShort = request.password.length < 8
        if (areFieldsBlank || isPasswordTooShort) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }

        val existingUser = userDataSource.getByEmail(request.email)
        if (existingUser != null) {
            call.respond(HttpStatusCode.Conflict, "User already exists")
            return@post
        }

        val saltedHash = hashingService.generateSaltedHash(request.password)
        val user = User(
            id = 0,
            email = request.email,
            password = saltedHash.hash,
            salt = saltedHash.salt,
            role = Role.Patient
        )

        val wasUserCreated = userDataSource.insert(user)
        if (!wasUserCreated) {
            call.respond(HttpStatusCode.InternalServerError, "Failed to create user")
            return@post
        }

        call.respond(HttpStatusCode.Created)
    }
}

fun Route.signIn(
    hashingService: HashingService,
    userDataSource: UserDataSource,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    post("signin") {
        val request = call.receiveNullable<AuthRequest>() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        val user = userDataSource.getByEmail(request.email)
        if (user == null) {
            call.respond(HttpStatusCode.Conflict, "User not found")
            return@post
        }

        val isValidPassword = hashingService.verify(
            value = request.password,
            saltedHash = com.example.security.hashing.SaltedHash(
                hash = user.password,
                salt = user.salt
            )
        )

        if (!isValidPassword) {
            call.respond(HttpStatusCode.Conflict, "Incorrect password")
            return@post
        }

        val token = tokenService.generate(
            config = tokenConfig,
            TokenClaim(
                name = "userId",
                value = user.id.toString()
            ),
            TokenClaim(
                name = "email",
                value = user.email
            ),
            TokenClaim(
                name = "role",
                value = user.role.name
            )
        )

        call.respond(
            status = HttpStatusCode.OK,
            message = AuthResponse(token = token)
        )
    }
}

fun Route.authenticate() {
    authenticate {
        get("authenticate") {
            call.respond(HttpStatusCode.OK)
        }
    }
}

fun Route.getSecretInfo() {
    authenticate {
        get("me") {
            val principal = call.principal<JWTPrincipal>()
            val userId = principal?.payload?.getClaim("userId")?.asString()
            val userEmail = principal?.payload?.getClaim("email")?.asString()
            val userRole = principal?.payload?.getClaim("role")?.asString()

            call.respond(
                HttpStatusCode.OK,
                mapOf(
                    "userId" to userId,
                    "email" to userEmail,
                    "role" to userRole
                )
            )
        }
    }
}