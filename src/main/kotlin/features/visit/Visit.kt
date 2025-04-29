package com.example.features.visit

import com.example.features.discount.Discount
import com.example.features.employee.Employee
import com.example.features.patient.Patient
import com.example.utils.VisitStatus
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