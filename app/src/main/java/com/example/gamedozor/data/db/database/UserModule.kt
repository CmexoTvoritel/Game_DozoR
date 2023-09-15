package com.example.gamedozor.data.db.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Singleton
    @Provides
    fun provideUserDao(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = UserDatabase::class.java,
        name = "user_database"
    ).build().userDao()
}