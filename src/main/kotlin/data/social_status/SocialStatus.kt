package com.example.data.social_status

import com.example.data.discount.Discount
import kotlinx.serialization.Serializable

@Serializable
data class SocialStatus(
    val id: Int,
    val discount: Discount,
    val description: String
)