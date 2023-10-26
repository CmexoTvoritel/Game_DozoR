package com.example.gamedozor.di.login

import com.example.gamedozor.presentation.ui.fragments.login.LoginFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class])
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)
}