package com.example.auth

import com.example.util.Role
import io.ktor.server.auth.Principal


data class UserPrincipal(val userId: Int, val email: String, val role: Role) : Principal