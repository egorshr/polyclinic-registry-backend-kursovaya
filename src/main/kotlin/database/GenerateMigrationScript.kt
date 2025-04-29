package com.example.database

import com.example.features.employee.Employees
import com.example.features.patient.Patients
import com.example.features.service.Services
import org.jetbrains.exposed.sql.ExperimentalDatabaseMigrationApi

@OptIn(ExperimentalDatabaseMigrationApi::class)
fun generateMigrationScript() {
    MigrationUtils.generateMigrationScript(
        Patients, Employees,
        scriptDirectory = MIGRATIONS_DIRECTORY,
        scriptName = "V2__Remove_default_column"
    )
}