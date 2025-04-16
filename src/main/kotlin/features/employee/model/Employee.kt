package com.example.features.employee.model

import com.example.features.specialty.model.Specialty
import com.example.utils.Gender
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable


@Serializable
data class Employee(
    val id: Int,
    val specialtyId: Specialty,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birthday: LocalDate,
    val gender: Gender,
    val jobTitle: String,
    val phoneNumber: String,
    val durationOfVisit: LocalTime?,
    val username: String,
    val email: String,
    val password: String
)
