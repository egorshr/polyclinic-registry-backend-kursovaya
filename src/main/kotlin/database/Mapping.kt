package com.example.database

import com.example.data.employee.Employee
import com.example.data.employee.Employees
import com.example.data.patient.Patient
import com.example.data.patient.Patients
import com.example.data.service.Service
import com.example.data.service.Services
import com.example.data.user.User
import com.example.data.user.Users
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.InsertStatement

fun ResultRow.toEmployee(): Employee {
    return Employee(
        id = this[Employees.id],
        specialtyId = this[Employees.specialityId],
        userId = this[Employees.userId],
        firstName = this[Employees.firstName],
        middleName = this[Employees.middleName],
        lastName = this[Employees.lastName],
        birthday = this[Employees.birthday],
        gender = this[Employees.gender],
        phoneNumber = this[Employees.phoneNumber],
        durationOfVisit = this[Employees.durationOfVisit],
    )
}

fun InsertStatement<Number>.from(employee: Employee) {
    this[Employees.id] = employee.id
    this[Employees.specialityId] = employee.specialtyId
    this[Employees.userId] = employee.userId
    this[Employees.firstName] = employee.firstName
    this[Employees.middleName] = employee.middleName
    this[Employees.lastName] = employee.lastName
    this[Employees.birthday] = employee.birthday
    this[Employees.gender] = employee.gender
    this[Employees.phoneNumber] = employee.phoneNumber
    this[Employees.durationOfVisit] = employee.durationOfVisit
}


fun ResultRow.toPatient(): Patient {
    return Patient(
        id = this[Patients.id],
        userId = this[Patients.userId],
        firstName = this[Patients.firstName],
        middleName = this[Patients.middleName],
        lastName = this[Patients.lastName],
        birthday = this[Patients.birthday],
        gender = this[Patients.gender],
        phoneNumber = this[Patients.phoneNumber],
        passportSeries = this[Patients.passportSeries],
        passportNumber = this[Patients.passportNumber],
        passportIssueDate = this[Patients.passportIssueDate],
        passportIssuedBy = this[Patients.passportIssuedBy],
        addressCountry = this[Patients.addressCountry],
        addressRegion = this[Patients.addressRegion],
        addressLocality = this[Patients.addressLocality],
        addressStreet = this[Patients.addressStreet],
        addressHouse = this[Patients.addressHouse],
        addressBody = this[Patients.addressBody],
        addressApartment = this[Patients.addressApartment]
    )
}

fun InsertStatement<Number>.from(patient: Patient) {
    this[Patients.id] = patient.id
    this[Patients.userId] = patient.userId
    this[Patients.firstName] = patient.firstName
    this[Patients.middleName] = patient.middleName
    this[Patients.lastName] = patient.lastName
    this[Patients.birthday] = patient.birthday
    this[Patients.gender] = patient.gender
    this[Patients.phoneNumber] = patient.phoneNumber
    this[Patients.passportSeries] = patient.passportSeries
    this[Patients.passportNumber] = patient.passportNumber
    this[Patients.passportIssueDate] = patient.passportIssueDate
    this[Patients.passportIssuedBy] = patient.passportIssuedBy
    this[Patients.addressCountry] = patient.addressCountry
    this[Patients.addressRegion] = patient.addressRegion
    this[Patients.addressLocality] = patient.addressLocality
    this[Patients.addressStreet] = patient.addressStreet
    this[Patients.addressHouse] = patient.addressHouse
    this[Patients.addressBody] = patient.addressBody
    this[Patients.addressApartment] = patient.addressApartment

}


fun ResultRow.toUser(): User {
    return User(
        id = this[Users.id],
        email = this[Users.email],
        password = this[Users.password],
        role = this[Users.role],
        salt = this[Users.salt]
    )
}

fun InsertStatement<Number>.from(user: User) {
    this[Users.id] = user.id
    this[Users.email] = user.email
    this[Users.password] = user.password
    this[Users.role] = user.role
    this[Users.salt] = user.salt

}


fun ResultRow.toService(): Service {
    return Service(
        id = this[Services.id],
        name = this[Services.name],
        price = this[Services.price]
    )
}