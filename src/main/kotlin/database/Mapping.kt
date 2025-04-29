package com.example.database

import com.example.features.employee.Employee
import com.example.features.employee.Employees
import com.example.features.patient.Patient
import com.example.features.patient.Patients
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.statements.InsertStatement

fun ResultRow.toEmployee(): Employee {
    return Employee(
        id = this[Employees.id],
        specialtyId = this[Employees.specialityId],
        firstName = this[Employees.firstName],
        middleName = this[Employees.middleName],
        lastName = this[Employees.lastName],
        birthday = this[Employees.birthday],
        gender = this[Employees.gender],
        phoneNumber = this[Employees.phoneNumber],
        durationOfVisit = this[Employees.durationOfVisit],
        username = this[Employees.username],
        email = this[Employees.email],
        password = this[Employees.password],
        role = this[Employees.role],
        salt = this[Employees.salt]
    )
}

fun InsertStatement<Number>.from(employee: Employee) {
    this[Employees.id] = employee.id
    this[Employees.specialityId] = employee.specialtyId
    this[Employees.firstName] = employee.firstName
    this[Employees.middleName] = employee.middleName
    this[Employees.lastName] = employee.lastName
    this[Employees.birthday] = employee.birthday
    this[Employees.gender] = employee.gender
    this[Employees.phoneNumber] = employee.phoneNumber
    this[Employees.durationOfVisit] = employee.durationOfVisit
    this[Employees.username] = employee.username
    this[Employees.email] = employee.email
    this[Employees.password] = employee.password
    this[Employees.role] = employee.role
    this[Employees.salt] = employee.salt
}


fun ResultRow.toPatient(): Patient {
    return Patient(
        id = this[Patients.id],
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
        addressApartment = this[Patients.addressApartment],
        username = this[Patients.username],
        email = this[Patients.email],
        password = this[Patients.password],
        role = this[Patients.role],
        salt = this[Patients.salt]
    )
}

fun InsertStatement<Number>.from(patient: Patient) {
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
    this[Patients.username] = patient.username
    this[Patients.email] = patient.email
    this[Patients.password] = patient.password
    this[Patients.role] = patient.role
    this[Patients.salt] = patient.salt
}