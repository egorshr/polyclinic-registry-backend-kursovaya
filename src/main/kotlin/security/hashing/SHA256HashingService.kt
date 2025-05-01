package com.example.security.hashing

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.SHA256
import dev.whyoleg.cryptography.random.CryptographyRandom


class SHA256HashingService : HashingService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun generateSaltedHash(value: String, saltLength: Int): SaltedHash {
        val salt = CryptographyRandom.nextBytes(saltLength)
        val saltAsHex = salt.toHexString()
        val hash = CryptographyProvider.Default
            .get(SHA256)
            .hasher()
            .hashBlocking((saltAsHex + value).encodeToByteArray())

        val hashAsHex = hash.toHexString()
        return SaltedHash(hash = hashAsHex, salt = saltAsHex)
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun verify(value: String, saltedHash: SaltedHash): Boolean {
        val recomputed = CryptographyProvider.Default
            .get(SHA256)
            .hasher()
            .hashBlocking((saltedHash.salt + value).encodeToByteArray())
            .toHexString()
        return recomputed == saltedHash.hash
    }
}