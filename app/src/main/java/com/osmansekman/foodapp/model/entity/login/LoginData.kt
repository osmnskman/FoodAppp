package com.osmansekman.foodapp.model.entity.login

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String
)
