package com.example.data.user

import com.example.util.Role
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val email: String,
    val password: String,
    val role: Role,
    val salt: String
)
