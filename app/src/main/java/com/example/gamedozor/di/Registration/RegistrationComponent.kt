package com.example.gamedozor.di.Registration

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.FRegistration.RegistrationFragment
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Singleton
@Component(modules = [RegistrationModule::class])
interface RegistrationComponent {
    fun inject(registrationFragment: RegistrationFragment)
}