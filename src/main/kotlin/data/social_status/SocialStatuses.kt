package com.example.data.social_status

import com.example.data.discount.Discounts
import org.jetbrains.exposed.sql.Table

object SocialStatuses : Table("social_statuses") {
    val id = integer("id").autoIncrement()
    val discount = reference("discount_id", Discounts.id)
    val description = varchar("description", 100)

    override val primaryKey = PrimaryKey(id)
}