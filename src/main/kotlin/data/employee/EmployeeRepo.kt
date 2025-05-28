package com.example.data.employee

interface EmployeeRepo {
    suspend fun getAllEmployees(): List<Employee>
//    suspend fun getEmployeeByUserId(userId: Int): Employee?
//    suspend fun insertEmployee(employee: Employee): Boolean
}