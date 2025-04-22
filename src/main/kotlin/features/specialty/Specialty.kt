package com.example.features.specialty

import kotlinx.serialization.Serializable

@Serializable
data class Specialty(
    val id: Int,
    val name: String
)