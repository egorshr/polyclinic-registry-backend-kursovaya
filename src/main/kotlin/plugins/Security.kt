package com.example.plugins

import auth.TokenConfig
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.auth.UserPrincipal
import com.example.data.user.UserRepo
import com.example.util.Role
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*

fun Application.configureSecurity(tokenConfig: TokenConfig) {
    authentication {
        jwt("auth-jwt") {
            realm = "ktor.io"
            verifier(
                JWT
                    .require(Algorithm.HMAC256(tokenConfig.secret))
                    .withAudience(tokenConfig.audience)
                    .withIssuer(tokenConfig.issuer)
                    .build()
            )
            validate { credential ->
                val userId = credential.payload.getClaim("userId").asInt()
                val email = credential.payload.getClaim("email").asString()
                val roleString = credential.payload.getClaim("role").asString()

                if (userId != null && email != null && roleString != null) {
                    try {
                        val role = Role.valueOf(roleString)
                        UserPrincipal(userId, email, role)
                    } catch (e: IllegalArgumentException) {
                        null
                    }
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }
}