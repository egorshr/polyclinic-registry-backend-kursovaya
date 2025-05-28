package com.example.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val token: String,
    val userId: Int,
    val email: String,
    val role: String
)