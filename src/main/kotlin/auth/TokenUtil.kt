package com.example.auth

import auth.TokenConfig
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.data.user.User
import java.util.*

fun generateToken(user: User, tokenConfig: TokenConfig): String {
    return JWT.create()
        .withAudience(tokenConfig.audience)
        .withIssuer(tokenConfig.issuer)
        .withClaim("userId", user.id)
        .withClaim("email", user.email)
        .withClaim("role", user.role.name)
        .withExpiresAt(Date(System.currentTimeMillis() + tokenConfig.expiresIn))
        .sign(Algorithm.HMAC256(tokenConfig.secret))
}