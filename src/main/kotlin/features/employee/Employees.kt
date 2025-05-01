package com.example.features.employee

import com.example.features.specialty.Specialties
import com.example.features.user.Users
import com.example.utils.Gender
import com.example.utils.Role
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import org.jetbrains.exposed.sql.kotlin.datetime.time

object Employees : Table("employees") {
    val id = integer("id").autoIncrement()
    val specialityId = reference("specialty_id", Specialties.id)
    val userId = reference("user_id", Users.id)
    val firstName = varchar("first_name", 32)
    val middleName = varchar("middle_name", 36).nullable()
    val lastName = varchar("last_name", 64)
    val birthday = date("birthday")
    val gender = enumerationByName<Gender>("gender", 10)
    val phoneNumber = varchar("phone_number", 18)
    val durationOfVisit = time("duration_of_visit").nullable()

    override val primaryKey = PrimaryKey(id)
}