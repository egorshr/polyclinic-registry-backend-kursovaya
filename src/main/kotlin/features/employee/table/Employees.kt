package com.example.entities.employee.table

import com.example.entities.specialty.table.Specialties
import com.example.utils.Gender
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.time


object Employees : Table("employees") {
    val id = integer("id").autoIncrement()
    val specialityId = reference("specialty_id", Specialties.id)
    val firstName = varchar("first_name", 32)
    val middleName = varchar("middle_name", 36).nullable()
    val lastName = varchar("last_name", 64)
    val birthday = date("birthday")
    val gender = enumerationByName("gender", 10, Gender::class)
    val jobTitle = varchar("job_title", 36)
    val phoneNumber = varchar("phone_number", 18)
    val durationOfVisit = time("duration_of_visit").nullable()
    val username = varchar("username", 100)
    val email = varchar("email", 100)
    val password = varchar("password", 100)

    override val primaryKey = PrimaryKey(id)
}