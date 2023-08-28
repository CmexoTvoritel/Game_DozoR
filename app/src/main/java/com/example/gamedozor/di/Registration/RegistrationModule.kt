package com.example.gamedozor.di.Registration

import com.example.gamedozor.data.api.RegApi.service.RegService
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RegistrationModule {

    @Provides
    @FragmentScope
    fun provideRegService(): RegService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RegService::class.java)
    }
}