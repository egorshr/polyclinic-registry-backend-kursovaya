package com.example.data.specialty

import kotlinx.serialization.Serializable

@Serializable
data class Specialty(
    val id: Int,
    val name: String
)