package com.example.plugins

import com.example.utils.Role
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.createRouteScopedPlugin
import io.ktor.server.auth.AuthenticationChecked
import io.ktor.server.auth.jwt.JWTPrincipal
import io.ktor.server.auth.principal
import io.ktor.server.response.respond

class PluginConfiguration {
    var roles: Set<Role> = emptySet()
}

val RoleBasedAuthPlugin = createRouteScopedPlugin(
    name = "RbacPlugin",
    createConfiguration = ::PluginConfiguration
) {
    val roles = pluginConfig.roles
    pluginConfig.apply {
        on(AuthenticationChecked) { call ->
            val tokenRole = getRoleFromToken(call)
            val role = Role.valueOf(tokenRole ?: "unknown")
            val isAuthorized = role in roles

            if (!isAuthorized) {
                call.respond(HttpStatusCode.Forbidden)
            }
        }
    }
}


private fun getRoleFromToken(call: ApplicationCall): String? {
    return call.principal<JWTPrincipal>()
        ?.payload
        ?.getClaim("role")
        ?.asString()
}
