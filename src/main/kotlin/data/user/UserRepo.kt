package com.example.data.user

interface UserRepo {
    suspend fun getByEmail(email: String): User?
    suspend fun getById(id: Int): User?
    suspend fun insert(user: User): Boolean
}