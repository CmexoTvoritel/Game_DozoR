package com.example.gamedozor.presentation.ui.fragments.registration.model

import com.google.gson.annotations.SerializedName

data class RegistrationModel(
    val email: String,
    @SerializedName("is_superuser")
    val isSuperUser: Boolean,
    val name: String,
    val surname: String,
    val password: String,
    @SerializedName("confrimPassword")
    val confirmPassword: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
)
