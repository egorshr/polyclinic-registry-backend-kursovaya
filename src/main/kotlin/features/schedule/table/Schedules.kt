package com.example.entities.schedule.table

import com.example.entities.employee.table.Employees
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.time

object Schedules : Table("schedules") {
    val id = integer("id").autoIncrement()
    val employeeId = reference("employee_id", Employees.id)
    val date = date("date")
    val timeFrom = time("time_from")
    val timeTo = time("time_to")

    override val primaryKey = PrimaryKey(id)
}