package com.example.gamedozor.presentation.ui.fragments

data class RegistrationModel(
    val email: String,
    val is_superuser: Boolean,
    val name: String,
    val surname: String,
    val password: String,
    val confrimPassword: String,
    val phone_number: String,
)
