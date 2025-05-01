package com.example.features.user

import com.example.utils.Role
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val email: String,
    val password: String,
    val role: Role,
    val salt: String
)
