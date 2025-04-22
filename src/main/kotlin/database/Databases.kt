package com.example.database

import com.example.migrations.MIGRATIONS_DIRECTORY
import com.example.migrations.generateMigrationScript
import io.ktor.server.application.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabases() {
    val url = environment.config.property("storage.jdbcURL").getString()
    val user = environment.config.property("storage.user").getString()
    val password = environment.config.property("storage.password").getString()
    val driver = environment.config.property("storage.driverClassName").getString()
    Database.connect(
        url = url,
        user = user,
        password = password,
        driver = driver
    )
    val flyway = Flyway.configure()
        .dataSource(url, user, password)
        .locations("/$MIGRATIONS_DIRECTORY")
        .baselineOnMigrate(true)
        .load()

    transaction {
        generateMigrationScript()
    }

    transaction {
        flyway.migrate()
    }

}
