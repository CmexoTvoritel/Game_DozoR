package com.example.gamedozor.di.Login

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.FLogin.LoginFragment
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
@Component(modules = [LoginModule::class], dependencies = [ActivityComponent::class])
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)
}