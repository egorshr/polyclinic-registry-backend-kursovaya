package com.example.data.employee

interface EmployeeDataSource {
    suspend fun getEmployeeByUserId(userId: Int): Employee?
    suspend fun insertEmployee(employee: Employee): Boolean
}