package com.example.gamedozor.di.Registration

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.FRegistration.RegistrationFragment
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
@Component(modules = [RegistrationModule::class], dependencies = [ActivityComponent::class])
interface RegistrationComponent {
    fun inject(registrationFragment: RegistrationFragment)
}