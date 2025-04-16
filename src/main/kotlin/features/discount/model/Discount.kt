package com.example.features.discount.model

import kotlinx.serialization.Serializable

@Serializable
data class Discount(
    val id: Int,
    val percent: Short
)
