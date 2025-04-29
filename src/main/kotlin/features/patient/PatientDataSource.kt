package com.example.features.patient


interface PatientDataSource {
    suspend fun getPatientByUsername(username: String): Patient?
    suspend fun insertPatient(patient: Patient): Boolean
}