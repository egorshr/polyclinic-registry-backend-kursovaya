package com.example.data.visit_service

import com.example.data.service.Services
import com.example.data.visit.Visits
import org.jetbrains.exposed.sql.Table

object VisitServices : Table("visit_services") {
    val visitId = reference("visit_id", Visits.id)
    val serviceId = reference("service_id", Services.id)

    override val primaryKey = PrimaryKey(visitId, serviceId)
}