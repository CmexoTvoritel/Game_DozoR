package com.example.gamedozor.di.Registration

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.ActivityMain.ActivityModule
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@FragmentScope
@Component(modules = [RegistrationModule::class], dependencies = [ActivityComponent::class])
interface RegistrationComponent {
    fun inject(registrationFragment: RegistrationFragment)
}