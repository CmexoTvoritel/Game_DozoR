package com.example.gamedozor.presentation.ui.fragments.FRegistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentRegistrationBinding
import com.example.gamedozor.presentation.ui.fragments.FRegistration.model.RegistrationModel
import com.example.gamedozor.presentation.ui.fragments.FRegistration.viewmodel.RegistrationViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var buttonToLoginFragment: TextView
    private lateinit var buttonCreateAccount: Button
    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setClickToButtons()
    }

    private fun setupView() {
        buttonToLoginFragment = binding.goToLoginText
        buttonCreateAccount = binding.createAccountButton
    }

    private fun setClickToButtons() {
        buttonToLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        buttonCreateAccount.setOnClickListener {
            val user = RegistrationModel(
                email = binding.inputEmail.editText?.text.toString(),
                password = binding.inputPassword.editText?.text.toString(),
                confrimPassword = binding.inputConfrimPassword.editText?.text.toString(),
                is_superuser = false,
                name = binding.inputName.editText?.text.toString(),
                surname = binding.inpurSurname.editText?.text.toString(),
                phone_number = binding.inputPhoneNumber.editText?.text.toString(),
                )
            CoroutineScope(Dispatchers.Main).launch {
                val answerOfReg = viewModel.regUserInApp(user)
                if (answerOfReg.isValide) {
                    findNavController().setGraph(R.navigation.nav_profile_graph)
                    val bottomNavigationView =
                        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
                    bottomNavigationView.visibility = View.VISIBLE
                } else {
                    binding.errorMessage.text = answerOfReg.message
                    binding.errorMessage.visibility = View.VISIBLE
                }
            }
        }
    }

}