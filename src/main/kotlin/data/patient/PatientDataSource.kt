package com.example.data.patient


interface PatientDataSource {
    suspend fun getPatientByUserId(userId: Int): Patient?
    suspend fun insertPatient(patient: Patient): Boolean
}