package com.example.features.visit.table

import com.example.features.discount.table.Discounts
import com.example.features.employee.table.Employees
import com.example.features.patient.table.Patients
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