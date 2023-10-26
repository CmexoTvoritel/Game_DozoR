package com.example.gamedozor.di.games

import androidx.fragment.app.Fragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyGamesModule::class, AllGamesModule::class])
interface GamesComponent {
    fun inject(gamesFragment: Fragment)
}