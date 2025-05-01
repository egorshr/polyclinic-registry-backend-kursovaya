package com.example.data.employee

import com.example.util.Gender
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id: Int,
    val specialtyId: Int,
    val userId :Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birthday: LocalDate,
    val gender: Gender,
    val phoneNumber: String,
    val durationOfVisit: LocalTime?,
)