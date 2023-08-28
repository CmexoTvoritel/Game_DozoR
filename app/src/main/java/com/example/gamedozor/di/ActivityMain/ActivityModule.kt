package com.example.gamedozor.di.ActivityMain

import android.app.Activity
import com.example.gamedozor.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity = activity
}