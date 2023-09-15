package com.example.gamedozor.data.api.LoginApi.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
)
