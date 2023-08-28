package com.example.gamedozor.di.Login

import com.example.gamedozor.data.api.LoginApi.service.LoginService
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LoginModule {

    @FragmentScope
    @Provides
    fun provideLoginService(): LoginService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(LoginService::class.java)
    }
}