package com.example.data.employee

import com.example.database.from
import com.example.database.toEmployee
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeDataSourceImpl : EmployeeDataSource {
    override suspend fun getEmployeeByUserId(userId: Int): Employee? = transaction {
        Employees.selectAll().where { Employees.userId eq userId }
            .firstOrNull()
            ?.toEmployee()
    }
    override suspend fun insertEmployee(employee: Employee): Boolean = transaction {
        Employees.insert { it.from(employee) }.insertedCount > 0
    }
}