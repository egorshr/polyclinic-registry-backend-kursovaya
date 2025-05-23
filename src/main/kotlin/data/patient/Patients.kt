package com.example.data.patient

import com.example.data.user.Users
import com.example.util.Gender
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

object Patients : Table("patients") {
    val id = integer("id").autoIncrement()
    val userId = reference("user_id", Users.id)
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

    override val primaryKey = PrimaryKey(id)
}