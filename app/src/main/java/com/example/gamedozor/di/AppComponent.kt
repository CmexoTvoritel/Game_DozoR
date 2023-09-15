package com.example.gamedozor.di

import android.content.Context
import androidx.room.Room
import com.example.gamedozor.data.db.database.UserDatabase
import com.example.gamedozor.data.db.database.UserModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UserModule::class])
interface AppComponent {

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

}