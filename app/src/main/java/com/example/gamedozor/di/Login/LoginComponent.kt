package com.example.gamedozor.di.Login

import com.example.gamedozor.di.ActivityMain.ActivityComponent
import com.example.gamedozor.di.scopes.FragmentScope
import com.example.gamedozor.presentation.ui.fragments.FLogin.LoginFragment
import dagger.Component
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class])
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)
}