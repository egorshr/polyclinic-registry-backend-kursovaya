package com.example.database


import com.example.data.discount.Discounts
import com.example.data.employee.Employees
import com.example.data.patient.Patients
import com.example.data.schedule.Schedules
import com.example.data.service.Services
import com.example.data.social_status.SocialStatuses
import com.example.data.specialty.Specialties
import com.example.data.user.Users
import com.example.data.visit.Visits
import com.example.data.visit_service.VisitServices
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

//    val flyWay = Flyway.configure()
//        .dataSource(url, user, password)
//        .locations("classpath:db/migration")
//        .baselineOnMigrate(true)
//        .load()

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
            VisitServices,
            Users
        )
    }
//    transaction {
//        generateMigrationScript()
//    }
//    transaction {
//        flyWay.migrate()
//    }
}


