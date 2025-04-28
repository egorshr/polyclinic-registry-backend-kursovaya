package com.example.features.service

import com.example.features.visit.Visits
import org.jetbrains.exposed.sql.Table

object Services : Table("services") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    val price = decimal("price", 10, 2)

    override val primaryKey = PrimaryKey(id)
}




