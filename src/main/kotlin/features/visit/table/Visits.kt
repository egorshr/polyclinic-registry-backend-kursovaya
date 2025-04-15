package com.example.entities.visit.table

import com.example.entities.discount.table.Discounts
import com.example.entities.employee.table.Employees
import com.example.entities.patient.table.Patients
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object Visits : Table("visits") {
    val id = integer("id").autoIncrement()
    val discountId = reference("discount_id", Discounts.id)
    val patientId = reference("patient_id", Patients.id)
    val employeeId = reference("employee_id", Employees.id)
    val dateAndTime = datetime("visit_date_and_time")

    override val primaryKey = PrimaryKey(id)
}