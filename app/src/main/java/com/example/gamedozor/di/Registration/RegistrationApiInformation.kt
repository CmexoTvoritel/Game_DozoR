package com.example.gamedozor.di.Registration

import com.example.gamedozor.data.api.RegApi.service.RegService
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.di.scopes.FragmentScope
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegistrationApiInformation @Inject constructor(private val api: RegService) {

    suspend fun regUser(user: RegModel): Response<RegModel> = api.registerUser(user)
}