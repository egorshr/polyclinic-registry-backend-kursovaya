package com.example.data.visit

import com.example.data.discount.Discounts
import com.example.data.employee.Employees
import com.example.data.patient.Patients
import com.example.util.VisitStatus
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Visits : Table("visits") {
    val id = integer("id").autoIncrement()
    val discountId = reference("discount_id", Discounts.id).nullable()
    val patientId = reference("patient_id", Patients.id)
    val employeeId = reference("employee_id", Employees.id)
    val dateAndTime = datetime("visit_date_and_time")
    val status = enumerationByName<VisitStatus>("status", 10)
    override val primaryKey = PrimaryKey(id)
}