package com.example.features.patient

import com.example.database.from
import com.example.database.toEmployee
import com.example.database.toPatient
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PatientDataSourceImpl : PatientDataSource {
    override suspend fun getPatientByUsername(username: String): Patient? = transaction {
        Patients.selectAll().where { Patients.username eq username}
            .firstOrNull()
            ?.toPatient()
    }

    override suspend fun insertPatient(patient: Patient): Boolean = transaction {
        Patients.insert { it.from(patient) }.insertedCount > 0
    }
}