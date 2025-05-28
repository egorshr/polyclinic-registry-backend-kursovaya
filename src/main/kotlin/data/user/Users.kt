package com.example.data.user

import com.example.util.Role
import org.jetbrains.exposed.sql.Table

object Users : Table("users") {
    val id = integer("id").autoIncrement()
    val email = varchar("email", 100)
    val password = varchar("password", 100)
    val role = enumerationByName<Role>("role", 20)
    val salt = varchar("salt", 16)

    override val primaryKey = PrimaryKey(id)
}