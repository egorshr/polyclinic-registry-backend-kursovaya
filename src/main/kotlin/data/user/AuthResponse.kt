package com.example.data.user

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(val token: String)
