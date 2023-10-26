package com.example.gamedozor.presentation.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentRegistrationBinding
import com.example.gamedozor.presentation.ui.fragments.registration.model.UIState
import com.example.gamedozor.presentation.ui.fragments.registration.model.RegistrationModel
import com.example.gamedozor.presentation.ui.fragments.registration.viewmodel.RegistrationViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setClickToButtons()
    }

    private fun setupObserver() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.response.collect{ state ->
            when (state) {
                UIState.SUCCESS -> {
                    goToNextScreen()
                }
                UIState.FAILED -> {
                    binding.errorMessage.visibility = View.VISIBLE
                }
                else -> {
                    //TODO : loading ICON
                }
            }
        }
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.action_registrationFragment_to_nav_profile_graph)
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun setClickToButtons() = binding.apply {
        goToLoginText.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        createAccountButton.setOnClickListener {
            val user = RegistrationModel(
                email = inputEmail.text.toString(),
                password = inputPassword.text.toString(),
                confirmPassword = inputConfrimPassword.text.toString(),
                isSuperUser = false,
                name = inputName.text.toString(),
                surname = inpurSurname.text.toString(),
                phoneNumber = inputPhoneNumber.text.toString(),
                )
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.regUserInApp(user)
            }
        }
    }

}