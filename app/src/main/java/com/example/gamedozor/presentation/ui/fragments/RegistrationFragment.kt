package com.example.gamedozor.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gamedozor.R
import com.example.gamedozor.data.api.RegApi.model.RegModel
import com.example.gamedozor.databinding.FragmentRegistrationBinding
import com.example.gamedozor.di.Registration.DaggerRegistrationComponent
import com.example.gamedozor.di.Registration.RegistrationApiInformation
import com.example.gamedozor.di.Registration.RegistrationModule
import com.example.gamedozor.presentation.ui.activity.MainActivity
import com.example.gamedozor.presentation.viewmodels.RegistrationViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class RegistrationFragment : Fragment() {

    private lateinit var buttonToLoginFragment: TextView
    private lateinit var buttonCreateAccount: Button
    private lateinit var binding: FragmentRegistrationBinding

    @Inject
    lateinit var regApi: RegistrationApiInformation

    private val viewModel: RegistrationViewModel by lazy {
        ViewModelProvider(this)[RegistrationViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependency()
        setupView()
        setClickToButtons()
    }

    private fun setupDependency() {
        DaggerRegistrationComponent.builder()
            .activityComponent((requireActivity() as MainActivity).activityComponent)
            .registrationModule(RegistrationModule())
            .build().inject(this)
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
                val answerOfReg = viewModel.regUserInApp(regApi, user)
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