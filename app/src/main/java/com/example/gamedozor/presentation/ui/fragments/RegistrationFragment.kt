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


class RegistrationFragment : Fragment() {

    private lateinit var buttonToLoginFragment: TextView
    private lateinit var buttonCreateAccount: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonToLoginFragment = view.findViewById(R.id.goToLoginText)
        buttonCreateAccount = view.findViewById(R.id.createAccountButton)
        setClickToButtons()
    }

    private fun setClickToButtons() {
        buttonToLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        buttonCreateAccount.setOnClickListener {
            findNavController().setGraph(R.navigation.nav_profile_graph)
            val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
            bottomNavigationView.visibility = View.VISIBLE
        }
    }

}