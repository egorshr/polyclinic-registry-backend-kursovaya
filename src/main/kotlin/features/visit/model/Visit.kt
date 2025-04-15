package com.example.entities.visit.model

import com.example.entities.discount.model.Discount
import com.example.entities.employee.model.Employee
import com.example.entities.patient.model.Patient
import kotlinx.datetime.LocalDateTime

data class Visit(
    val id: Int,
    val discountId: Discount,
    val patientId: Patient,
    val employeeId: Employee,
    val dateAndTime: LocalDateTime
)
