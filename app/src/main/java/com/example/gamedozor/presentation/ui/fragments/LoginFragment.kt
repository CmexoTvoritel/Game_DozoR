package com.example.gamedozor.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment() {

    private lateinit var buttonToRegistrationFragment: TextView
    private lateinit var buttonLogin: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonToRegistrationFragment = view.findViewById(R.id.goToRegistrationText)
        buttonLogin = view.findViewById(R.id.signInAccountButton)
        setClickToButtons()
    }

    private fun setClickToButtons() {
        buttonToRegistrationFragment.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        buttonLogin.setOnClickListener {
            findNavController().setGraph(R.navigation.nav_profile_graph)
            val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
            bottomNavigationView.visibility = View.VISIBLE
        }
    }

}