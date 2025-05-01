package com.example.database

import com.example.data.user.Users
import org.jetbrains.exposed.sql.ExperimentalDatabaseMigrationApi

@OptIn(ExperimentalDatabaseMigrationApi::class)
fun generateMigrationScript() {
    MigrationUtils.generateMigrationScript(
        Users,
        scriptDirectory = MIGRATIONS_DIRECTORY,
        scriptName = "V2__Remove_username_column"
    )
}