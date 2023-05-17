package com.example.gamedozor.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R

class LoginFragment : Fragment() {

    private lateinit var buttonToRegistrationFragment: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonToRegistrationFragment = view.findViewById(R.id.goToRegistrationText)
        setClickToButtons()
    }

    private fun setClickToButtons() {
        buttonToRegistrationFragment.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
    }

}