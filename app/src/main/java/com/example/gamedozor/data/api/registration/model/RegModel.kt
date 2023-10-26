package com.example.gamedozor.data.api.registration.model

data class RegModel(
    val email: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean,
    val name: String,
    val password: String,
    val patronymic: String,
    val phone_number: String,
    val surname: String
)

data class RegAnswer(
    val message: String,
    val isValide: Boolean,
)