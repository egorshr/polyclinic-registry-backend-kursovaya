package com.example.data.user

import com.example.database.from
import com.example.database.toUser
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepoImpl : UserRepo {
    override suspend fun getByEmail(email: String): User? = transaction {
        Users.selectAll().where { Users.email eq email }
            .firstOrNull()
            ?.toUser()
    }

    override suspend fun getById(id: Int): User? = transaction {
        Users.selectAll().where { Users.id eq id }
            .firstOrNull()
            ?.toUser()
    }

    override suspend fun insert(user: User): Boolean = transaction {
        Users.insert { it.from(user) }.insertedCount > 0
    }

}