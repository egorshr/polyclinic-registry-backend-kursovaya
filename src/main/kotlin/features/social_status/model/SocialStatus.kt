package com.example.entities.social_status.model

import com.example.entities.discount.model.Discount
import kotlinx.serialization.Serializable

@Serializable
data class SocialStatus(
    val id: Int,
    val discount: Discount,
    val description: String
)
