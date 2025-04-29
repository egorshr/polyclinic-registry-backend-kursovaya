package com.example.features.employee

import com.example.features.specialty.Specialty
import com.example.utils.Gender
import com.example.utils.Role
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id: Int,
    val specialtyId: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birthday: LocalDate,
    val gender: Gender,
    val phoneNumber: String,
    val durationOfVisit: LocalTime?,
    val username: String,
    val email: String,
    val password: String,
    val role: Role,
    val salt: String
)