package com.example.features.discount.table

import org.jetbrains.exposed.sql.Table

object Discounts : Table("discounts") {
    val id = integer("id").autoIncrement()
    val percent = short("percent")

    override val primaryKey = PrimaryKey(id)

}