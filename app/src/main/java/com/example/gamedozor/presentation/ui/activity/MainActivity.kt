package com.example.gamedozor.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.gamedozor.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNavGraph()
        setupBottomNavigationBar()
    }

    private fun setNavGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navMainHostActivity) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView = findViewById(R.id.bottomNavigationBar)
    }

    private fun setupBottomNavigationBar() {
        bottomNavigationView.visibility = View.GONE
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile_menu -> {
                    navController.setGraph(R.navigation.nav_profile_graph)
                    true
                }
                R.id.available_games_menu -> {
                    navController.setGraph(R.navigation.nav_available_games_graph)
                    true
                }
                R.id.chats_menu -> {
                    navController.setGraph(R.navigation.nav_chats_graph)
                    true
                }
                R.id.my_games_menu -> {
                    navController.setGraph(R.navigation.nav_my_games_graph)
                    true
                }
                else -> false
            }
        }
    }

}