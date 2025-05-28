package com.example.data.service

import com.example.database.toService
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ServiceRepoImpl : ServiceRepo {
    override suspend fun getAllServices(): List<Service> = transaction {
        Services.selectAll().map { it.toService() }
    }
}