package com.example.gamedozor.di.Profile

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.FProfile.ProfileFragment
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
@Component(modules = [ProfileModule::class], dependencies = [ActivityComponent::class])
interface ProfileComponent {

    fun inject(profileFragment: ProfileFragment)
}