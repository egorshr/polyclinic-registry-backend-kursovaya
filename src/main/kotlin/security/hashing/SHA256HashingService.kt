package com.example.security.hashing

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.SHA256
import dev.whyoleg.cryptography.random.CryptographyRandom


class SHA256HashingService : HashingService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun generateSaltedHash(value: String, saltLength: Int): SaltedHash {
        val saltBytes = CryptographyRandom.nextBytes(saltLength)
        val saltHex = saltBytes.toHexString()
        val hashBytes = CryptographyProvider.Default
            .get(SHA256)
            .hasher()
            .hashBlocking((saltHex + value).encodeToByteArray())

        val hashHex = hashBytes.toHexString()
        return SaltedHash(hash = hashHex, salt = saltHex)
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