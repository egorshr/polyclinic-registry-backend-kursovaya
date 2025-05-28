package com.example

import auth.TokenConfig
import com.example.data.employee.EmployeeRepo
import com.example.data.patient.PatientRepo
import com.example.data.service.ServiceRepo
import com.example.data.user.UserRepo
import com.example.database.configureDatabases
import com.example.plugins.configureFrameworks
import com.example.plugins.configureRouting
import com.example.plugins.configureSecurity
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.koin.ktor.ext.inject

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {

    val userRepo by inject<UserRepo>()
    val serviceRepo by inject<ServiceRepo>()
    val employeeRepo by inject<EmployeeRepo>()
    val patientRepo by inject<PatientRepo>()

    val tokenConfig by inject<TokenConfig>()

    configureSerialization()
    configureDatabases()
    configureFrameworks()
    configureSecurity(tokenConfig)
    configureRouting()

}