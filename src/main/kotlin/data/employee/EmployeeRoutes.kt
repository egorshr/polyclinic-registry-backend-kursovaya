package com.example.data.employee

import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Route.employeeRoutes(employeeRepo: EmployeeRepo) {
    route("employees") {
        get {
            val employees = employeeRepo.getAllEmployees()
            call.respond(employees)
        }
    }
}