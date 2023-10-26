package com.example.gamedozor.di.profile

import com.example.gamedozor.presentation.ui.fragments.profile.ProfileFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProfileModule::class])
interface ProfileComponent {

    fun inject(profileFragment: ProfileFragment)
}