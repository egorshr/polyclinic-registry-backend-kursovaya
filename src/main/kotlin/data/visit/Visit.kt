package com.example.data.visit

import com.example.util.VisitStatus
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Visit(
    val id: Int,
    val discountId: Int,
    val patientId: Int,
    val employeeId: Int,
    val dateAndTime: LocalDateTime,
    val status: VisitStatus
)