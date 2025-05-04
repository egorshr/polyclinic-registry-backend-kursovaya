package com.example.routing


import com.example.util.Role
import com.example.util.authorized
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureRoleBasedRoutes() {
    get("/") {
        call.respond(HttpStatusCode.OK, "Welcome to Polyclinic API")
    }

    authenticate {
        get("/auth-required") {
            call.respond(HttpStatusCode.OK, "You're authenticated!")
        }
    }

    authorized(Role.Admin) {
        get("/admin/dashboard") {
            call.respond(HttpStatusCode.OK, "Admin Dashboard")
        }

        get("/admin/users") {
            call.respond(HttpStatusCode.OK, "User Management Panel")
        }
    }

    authorized(Role.Doctor) {
        get("/doctor/patients") {
            call.respond(HttpStatusCode.OK, "Your Patients List")
        }

        get("/doctor/schedule") {
            call.respond(HttpStatusCode.OK, "Your Schedule")
        }
    }

    authorized(Role.Patient) {
        get("/patient/appointments") {
            call.respond(HttpStatusCode.OK, "Your Appointments")
        }

        get("/patient/history") {
            call.respond(HttpStatusCode.OK, "Your Medical History")
        }
    }

    authorized(Role.Admin, Role.Register) {
        get("/register/patients") {
            call.respond(HttpStatusCode.OK, "Patient Registration System")
        }
    }
}