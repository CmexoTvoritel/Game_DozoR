package com.example.gamedozor.di.registration

import com.example.gamedozor.data.api.registration.service.RegService
import com.example.gamedozor.data.api.registration.model.RegModel
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegistrationApiInformation @Inject constructor(private val api: RegService) {

    suspend fun regUser(user: RegModel): Response<RegModel> = api.registerUser(user)
}