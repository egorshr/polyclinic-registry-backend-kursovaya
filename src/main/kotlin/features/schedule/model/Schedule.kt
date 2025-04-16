package com.example.features.schedule.model

import com.example.features.employee.model.Employee
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val id: Int,
    val employeeId: Employee,
    val date: LocalDate,
    val timeFrom: LocalTime,
    val timeTo: LocalTime
)
