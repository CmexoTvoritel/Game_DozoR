package com.example.gamedozor.di.games

import com.example.gamedozor.data.api.games.service.GamesService
import com.example.gamedozor.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MyGamesModule {

    @Singleton
    @Provides
    fun provideMyGamesService(): GamesService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(GamesService::class.java)
    }
}