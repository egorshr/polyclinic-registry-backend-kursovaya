package com.example.routing

import com.example.data.user.UserDataSource
import com.example.security.hashing.HashingService
import io.ktor.server.routing.Route

fun Route.signUp(
    hashingService: HashingService,
    userDataSource: UserDataSource
) {

}