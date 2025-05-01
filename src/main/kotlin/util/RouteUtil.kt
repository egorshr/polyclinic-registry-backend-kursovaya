package com.example.util

import com.example.plugins.RoleBasedAuthPlugin
import io.ktor.server.routing.Route

fun Route.authorized(vararg hasAnyRole: Role, build: Route.() -> Unit) {
    install(RoleBasedAuthPlugin) { roles = hasAnyRole.toSet() }
    build()
}