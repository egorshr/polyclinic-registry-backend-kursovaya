package com.example

import com.example.data.employee.EmployeeDataSourceImpl
import com.example.data.patient.PatientDataSourceImpl
import com.example.data.user.UserDataSourceImpl
import com.example.database.configureDatabases
import com.example.plugins.configureFrameworks
import com.example.plugins.configureRouting
import com.example.plugins.configureSecurity
import com.example.plugins.configureSerialization
import com.example.routing.authenticate
import com.example.routing.getSecretInfo
import com.example.routing.signIn
import com.example.routing.signUp
import com.example.security.hashing.SHA256HashingService
import com.example.security.token.JwtTokenService
import com.example.security.token.TokenConfig
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    val userDataSource = UserDataSourceImpl()
    val employeeDataSource = EmployeeDataSourceImpl()
    val patientDataSource = PatientDataSourceImpl()
    val tokenService = JwtTokenService()
    val tokenConfig = TokenConfig(
        issuer = environment.config.property("jwt.issuer").getString(),
        audience = environment.config.property("jwt.audience").getString(),
        expiresIn = 365L * 1000L * 60L * 60L * 24L,
        secret = System.getenv("JWT_SECRET")
    )
    val hashingService = SHA256HashingService()

    configureSerialization()
    configureDatabases()
    configureFrameworks()
    configureSecurity(tokenConfig)
    configureRouting(userDataSource, hashingService, tokenService, tokenConfig)

}