package com.example.data.specialty

import org.jetbrains.exposed.sql.Table

object Specialties : Table("specialties") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 36)

    override val primaryKey = PrimaryKey(id)
}