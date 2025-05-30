package com.example.data.patient

import com.example.database.from
import com.example.database.toPatient
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PatientRepoImpl : PatientRepo {
    override suspend fun getPatientByUserId(userId: Int): Patient? = transaction {
        Patients.selectAll().where { Patients.userId eq userId }
            .firstOrNull()
            ?.toPatient()
    }

    override suspend fun insertPatient(patient: Patient): Boolean = transaction {
        Patients.insert { it.from(patient) }.insertedCount > 0
    }
}