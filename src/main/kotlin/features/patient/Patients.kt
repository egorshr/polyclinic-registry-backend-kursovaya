package com.example.features.patient

import com.example.utils.Gender
import com.example.utils.Role
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

object Patients : Table("patients") {
    val id = integer("id").autoIncrement()
    val gender = enumerationByName<Gender>("gender", 10)
    val firstName = varchar("first_name", 32)
    val middleName = varchar("middle_name", 36).nullable()
    val lastName = varchar("last_name", 64)
    val birthday = date("birthday")
    val phoneNumber = varchar("phone_number", 18)
    val passportSeries = varchar("passport_series", 45)
    val passportNumber = varchar("passport_number", 45)
    val passportIssueDate = date("passport_issue_date")
    val passportIssuedBy = varchar("passport_issued_by", 45)
    val addressCountry = varchar("address_country", 45)
    val addressRegion = varchar("address_region", 45)
    val addressLocality = varchar("address_locality", 45)
    val addressStreet = varchar("address_street", 45)
    val addressHouse = integer("address_house")
    val addressBody = integer("address_body")
    val addressApartment = integer("address_apartment")
    val username = varchar("username", 100)
    val email = varchar("email", 100)
    val password = varchar("password", 100)
    val role = enumerationByName<Role>("role", 10).default(Role.Patient)
    val salt = varchar("salt", 64)

    override val primaryKey = PrimaryKey(id)
}