package com.example.data.service

import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.serviceRoutes(serviceRepo: ServiceRepo) {
    route("services") {
        get {
            val services = serviceRepo.getAllServices()
            call.respond(services)
        }
    }
}
