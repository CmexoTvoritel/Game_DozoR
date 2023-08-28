package com.example.gamedozor.di.Login

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.LoginFragment
import dagger.Component

@FragmentScope
@Component(modules = [LoginModule::class], dependencies = [ActivityComponent::class])
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)
}