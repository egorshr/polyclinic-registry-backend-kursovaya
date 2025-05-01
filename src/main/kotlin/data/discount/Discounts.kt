package com.example.data.discount

import org.jetbrains.exposed.sql.Table

object Discounts : Table("discounts") {
    val id = integer("id").autoIncrement()
    val percent = short("percent")

    override val primaryKey = PrimaryKey(id)

}