package com.example.gamedozor.di.Registration

import com.example.gamedozor.data.api.RegApi.service.RegService
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.di.scopes.FragmentScope
import retrofit2.Response
import javax.inject.Inject

@FragmentScope
class RegistrationApiInformation @Inject constructor(private val api: RegService) {

    suspend fun regUser(user: RegModel): Response<RegModel> = api.registerUser(user)
}