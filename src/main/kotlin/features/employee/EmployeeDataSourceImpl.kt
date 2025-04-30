package com.example.features.employee

import com.example.database.from
import com.example.database.toEmployee
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeDataSourceImpl : EmployeeDataSource {
    override suspend fun getEmployeeByUsername(username: String): Employee? = transaction {
        Employees.selectAll().where { Employees.username eq username}
            .firstOrNull()
            ?.toEmployee()
    }
    override suspend fun insertEmployee(employee: Employee): Boolean = transaction {
        Employees.insert { it.from(employee) }.insertedCount > 0
    } 
}