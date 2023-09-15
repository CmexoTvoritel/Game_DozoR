package com.example.gamedozor.di.Registration

import com.example.gamedozor.data.api.RegApi.service.RegService
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RegistrationModule {

    @Provides
    @Singleton
    fun provideRegService(): RegService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RegService::class.java)
    }
}