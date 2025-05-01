package com.example.services

import com.example.database.from
import com.example.database.toPatient
import com.example.features.patient.Patient
import com.example.features.patient.PatientDataSource
import com.example.features.patient.Patients
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PatientDataSourceImpl : PatientDataSource {
    override suspend fun getPatientByUserId(userId: Int): Patient? = transaction {
        Patients.selectAll().where { Patients.userId eq userId }
            .firstOrNull()
            ?.toPatient()
    }

    override suspend fun insertPatient(patient: Patient): Boolean = transaction {
        Patients.insert { it.from(patient) }.insertedCount > 0
    }
}