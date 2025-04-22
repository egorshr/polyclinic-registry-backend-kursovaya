package com.example.features.social_status

import com.example.features.discount.Discount
import kotlinx.serialization.Serializable

@Serializable
data class SocialStatus(
    val id: Int,
    val discount: Discount,
    val description: String
)