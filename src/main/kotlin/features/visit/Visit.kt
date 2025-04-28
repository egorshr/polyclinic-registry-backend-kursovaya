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
    val discountId: Discount,
    val patientId: Patient,
    val employeeId: Employee,
    val dateAndTime: LocalDateTime,
    val status: VisitStatus
)