package com.example.data.schedule

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val id: Int,
    val employeeId: Int,
    val date: LocalDate,
    val timeFrom: LocalTime,
    val timeTo: LocalTime
)