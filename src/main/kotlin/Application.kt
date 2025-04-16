package com.example

import com.example.database.configureDatabases
import com.example.plugins.configureFrameworks
import com.example.plugins.configureRouting
import com.example.plugins.configureSecurity
import com.example.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureFrameworks()
    configureSecurity()
    configureRouting()
}
