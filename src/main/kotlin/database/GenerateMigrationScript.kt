package com.example.database

import com.example.features.employee.Employees
import com.example.features.patient.Patients
import com.example.features.user.Users
import org.jetbrains.exposed.sql.ExperimentalDatabaseMigrationApi

@OptIn(ExperimentalDatabaseMigrationApi::class)
fun generateMigrationScript() {
    MigrationUtils.generateMigrationScript(
        Users,
        scriptDirectory = MIGRATIONS_DIRECTORY,
        scriptName = "V2__Remove_username_column"
    )
}