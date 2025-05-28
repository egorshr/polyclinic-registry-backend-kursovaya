@file:OptIn(ExperimentalEncodingApi::class)

package com.example.auth

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.SHA256
import dev.whyoleg.cryptography.random.CryptographyRandom
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class PasswordHasher {
    private val provider = CryptographyProvider.Default
    private val sha256 = provider.get(SHA256)
    private val random = CryptographyRandom

    suspend fun hashPassword(password: String, salt: ByteArray): String {
        val passwordBytes = password.encodeToByteArray()
        val saltedPassword = passwordBytes + salt

        val hasher = sha256.hasher()
        val hash = hasher.hash(saltedPassword)

        val combined = salt + hash
        return Base64.encode(combined)
    }

    suspend fun verifyPassword(password: String, storedHash: String): Boolean {
        return try {
            val combined = Base64.decode(storedHash)
            val salt = combined.sliceArray(0..15) 
            val expectedHash = hashPassword(password, salt)
            
            expectedHash == storedHash
        } catch (e: Exception) {
            false
        }
    }

    fun generateSalt(): ByteArray {
        return random.nextBytes(16)
    }

    fun saltToString(salt: ByteArray): String {
        return Base64.encode(salt)
    }

    fun saltFromString(saltString: String): ByteArray {
        return Base64.decode(saltString)
    }
}
