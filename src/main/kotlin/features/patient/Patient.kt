package com.example.features.patient

import com.example.utils.Gender
import com.example.utils.Role
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Patient(
    val id: Int,
    val userId: Int,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val birthday: LocalDate,
    val gender: Gender,
    val phoneNumber: String,
    val passportSeries: String,
    val passportNumber: String,
    val passportIssueDate: LocalDate,
    val passportIssuedBy: String,
    val addressCountry: String,
    val addressRegion: String,
    val addressLocality: String,
    val addressStreet: String,
    val addressHouse: Int,
    val addressBody: Int,
    val addressApartment: Int,
)