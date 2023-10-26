package com.example.gamedozor.di.registration

import com.example.gamedozor.presentation.ui.fragments.registration.RegistrationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RegistrationModule::class])
interface RegistrationComponent {
    fun inject(registrationFragment: RegistrationFragment)
}