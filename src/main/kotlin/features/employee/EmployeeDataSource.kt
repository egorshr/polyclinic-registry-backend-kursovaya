package com.example.features.employee

interface EmployeeDataSource {
    suspend fun getEmployeeByUsername(username: String): Employee?
    suspend fun insertEmployee(employee: Employee): Boolean
}