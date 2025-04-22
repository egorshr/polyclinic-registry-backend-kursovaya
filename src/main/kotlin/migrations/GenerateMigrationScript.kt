package com.example.migrations

import com.example.features.visit.Visits
import org.jetbrains.exposed.sql.ExperimentalDatabaseMigrationApi

const val MIGRATIONS_DIRECTORY = "migrations"

@OptIn(ExperimentalDatabaseMigrationApi::class)
fun generateMigrationScript() {
    MigrationUtils.generateMigrationScript(
        Visits,
        scriptDirectory = MIGRATIONS_DIRECTORY,
        scriptName = "add status"
    )
}