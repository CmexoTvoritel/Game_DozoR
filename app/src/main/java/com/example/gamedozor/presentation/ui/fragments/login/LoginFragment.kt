package com.example.gamedozor.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentLoginBinding
import com.example.gamedozor.presentation.ui.fragments.registration.model.UIState
import com.example.gamedozor.presentation.ui.fragments.login.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setClickToButtons()
    }

    private fun setupView() {
        lifecycleScope.launch {
            viewModel.response.collect {state ->
                when(state) {
                    UIState.SUCCESS -> {
                        goToNextScreen()
                    }
                    UIState.FAILED -> {
                        //TODO: Excpetion
                    }
                    else -> {
                        //TODO:
                    }
                }
            }
        }
    }

    private fun goToNextScreen() {
        findNavController().setGraph(R.navigation.nav_profile_graph)
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun setClickToButtons() = binding.apply {
        goToRegistrationText.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        signInAccountButton.setOnClickListener {
            lifecycleScope.launch {
                viewModel.loginUserInApp(
                    userLogin = inputEmail.text.toString(),
                    userPassword = InputPassword.text.toString(),
                    isAlwaysLogin = true
                )
            }
        }
    }

}