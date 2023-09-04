package com.example.gamedozor.di.Profile

import com.example.gamedozor.data.api.UserApi.model.UserModel
import com.example.gamedozor.data.api.UserApi.service.UserService
import com.example.gamedozor.di.scopes.FragmentScope
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class ProfileInformation @Inject constructor(private val api: UserService) {

    suspend fun getUserInfo(authToken: String): Response<UserModel> = api.getUserInfo(authToken = authToken)
}