package com.example.features.employee

interface EmployeeDataSource {
    suspend fun getEmployeeByUserId(userId: Int): Employee?
    suspend fun insertEmployee(employee: Employee): Boolean
}