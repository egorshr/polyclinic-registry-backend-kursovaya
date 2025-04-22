package com.example.features.service

import com.example.features.visit.Visits
import org.jetbrains.exposed.sql.Table

object Services : Table("services") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    val price = decimal("price", 10, 2)

    override val primaryKey = PrimaryKey(id)
}


object VisitServices : Table("visit_services") {
    val visitId = reference("visit_id", Visits.id)
    val serviceId = reference("service_id", Services.id)

    override val primaryKey = PrimaryKey(visitId, serviceId)
}

