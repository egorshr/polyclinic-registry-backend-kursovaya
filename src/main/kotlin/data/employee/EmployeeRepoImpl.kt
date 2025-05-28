package com.example.data.employee

import com.example.database.from
import com.example.database.toEmployee
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class EmployeeRepoImpl : EmployeeRepo {

    //    override suspend fun getEmployeeByUserId(userId: Int): Employee? = transaction {
//        Employees.selectAll().where { Employees.userId eq userId }
//            .firstOrNull()
//            ?.toEmployee()
//    }
//    override suspend fun insertEmployee(employee: Employee): Boolean = transaction {
//        Employees.insert { it.from(employee) }.insertedCount > 0
//    }
    override suspend fun getAllEmployees(): List<Employee> = transaction {
        Employees.selectAll().map { it.toEmployee() }
    }
}