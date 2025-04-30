package com.example.plugins


import com.example.features.discount.Discounts
import com.example.features.employee.Employees
import com.example.features.patient.Patients
import com.example.features.schedule.Schedules
import com.example.features.service.Services
import com.example.features.social_status.SocialStatuses
import com.example.features.specialty.Specialties
import com.example.features.visit.Visits
import com.example.features.visit_service.VisitServices
import io.ktor.server.application.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

const val MIGRATIONS_DIRECTORY = "src/main/resources/db/migration"

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

    val flyWay = Flyway.configure()
        .dataSource(url, user, password)
        .locations("classpath:db/migration")
        .baselineOnMigrate(true)
        .load()

    transaction {
        SchemaUtils.create(
            Discounts,
            Employees,
            Patients,
            Schedules,
            Services,
            SocialStatuses,
            Specialties,
            Visits,
            VisitServices
        )
    }
//    transaction {
//        generateMigrationScript()
//    }
//    transaction {
//        flyWay.migrate()
//    }
}


