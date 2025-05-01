package com.example.data.user

interface UserDataSource {
    suspend fun getUserByEmail(email: String): User?
    suspend fun getUserById(id: Int): User?
    suspend fun insertUser(user: User): Boolean
}