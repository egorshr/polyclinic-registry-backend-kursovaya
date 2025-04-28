package com.example.features.visit_service

import com.example.features.service.Services
import com.example.features.visit.Visits
import org.jetbrains.exposed.sql.Table

object VisitServices : Table("visit_services") {
    val visitId = reference("visit_id", Visits.id)
    val serviceId = reference("service_id", Services.id)

    override val primaryKey = PrimaryKey(visitId, serviceId)
}