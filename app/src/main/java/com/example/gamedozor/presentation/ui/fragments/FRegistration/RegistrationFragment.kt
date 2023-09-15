package com.example.gamedozor.presentation.ui.fragments.FRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentRegistrationBinding
import com.example.gamedozor.presentation.ui.UIState
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import com.example.gamedozor.presentation.ui.fragments.FRegistration.viewmodel.RegistrationViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var buttonToLoginFragment: TextView
    private lateinit var buttonCreateAccount: Button
    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
        setClickToButtons()
    }

    private fun setupObserver() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.response.collect{ state ->
            if (state == UIState.SUCCESS) {
                findNavController().setGraph(R.navigation.nav_profile_graph)
                    val bottomNavigationView =
                        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
                    bottomNavigationView.visibility = View.VISIBLE
            } else if(state == UIState.FAILED) {
                binding.errorMessage.visibility = View.VISIBLE
            } else {
                //TODO : loading ICON
            }
        }
    }

    private fun setupView() {
        buttonToLoginFragment = binding.goToLoginText
        buttonCreateAccount = binding.createAccountButton
    }

    private fun setClickToButtons() = binding.apply {
        buttonToLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        buttonCreateAccount.setOnClickListener {
            val user = RegistrationModel(
                email = inputEmail.editText?.text.toString(),
                password = inputPassword.editText?.text.toString(),
                confrimPassword = inputConfrimPassword.editText?.text.toString(),
                is_superuser = false,
                name = inputName.editText?.text.toString(),
                surname = inpurSurname.editText?.text.toString(),
                phone_number = inputPhoneNumber.editText?.text.toString(),
                )
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.regUserInApp(user)
            }
        }
    }

}