package com.osmansekman.foodapp.model.entity.mealadd


import com.google.gson.annotations.SerializedName

data class MealAddResponse(
    @SerializedName("message")
    val message: Message,
    @SerializedName("success")
    val success: Boolean
)