package com.example.gamedozor.di.ActivityMain

import android.app.Activity
import com.example.gamedozor.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ActivityModule () {


    @ActivityScope
    @Provides
    fun provideActivity(activity: Activity): Activity = activity
}