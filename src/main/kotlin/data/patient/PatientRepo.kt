package com.example.data.patient


interface PatientRepo {
    suspend fun getPatientByUserId(userId: Int): Patient?
    suspend fun insertPatient(patient: Patient): Boolean
}