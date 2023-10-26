package com.example.gamedozor.di.activitymain

import com.example.gamedozor.di.AppComponent
import com.example.gamedozor.di.scopes.ActivityScope
import com.example.gamedozor.presentation.ui.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}