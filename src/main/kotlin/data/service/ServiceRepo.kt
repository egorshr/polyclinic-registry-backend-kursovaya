package com.example.data.service

interface ServiceRepo {
    suspend fun getAllServices(): List<Service>
}