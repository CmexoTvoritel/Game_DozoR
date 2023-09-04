package com.example.gamedozor.data.db.database

import android.content.Context
import androidx.room.Room
import com.example.gamedozor.data.db.repository.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
class UserModule {

//    @Singleton
//    @Provides
//    fun provideUserDao (
//        @ApplicationContext context: Context
//    ): UserDao {
//        synchronized(this) {
//            return Room.databaseBuilder(
//                context,
//                UserDatabase::class.java,
//                "user_database"
//            ).build().userDao()
//        }
//    }
}