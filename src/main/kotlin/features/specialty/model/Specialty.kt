package com.example.entities.specialty.model

import kotlinx.serialization.Serializable

@Serializable
data class Specialty(
    val id: Int,
    val name: String
)
