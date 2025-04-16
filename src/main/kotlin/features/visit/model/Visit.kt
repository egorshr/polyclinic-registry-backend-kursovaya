package com.example.features.visit.model

import com.example.features.discount.model.Discount
import com.example.features.employee.model.Employee
import com.example.features.patient.model.Patient
import kotlinx.datetime.LocalDateTime

data class Visit(
    val id: Int,
    val discountId: Discount,
    val patientId: Patient,
    val employeeId: Employee,
    val dateAndTime: LocalDateTime
)
