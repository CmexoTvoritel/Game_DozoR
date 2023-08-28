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
import com.example.gamedozor.data.api.LoginApi.model.LoginModel
import com.example.gamedozor.databinding.FragmentLoginBinding
import com.example.gamedozor.di.Login.DaggerLoginComponent
import com.example.gamedozor.di.Login.LoginApiInformation
import com.example.gamedozor.di.Login.LoginModule
import com.example.gamedozor.presentation.ui.activity.MainActivity
import com.example.gamedozor.presentation.viewmodels.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var buttonToRegistrationFragment: TextView
    private lateinit var buttonLogin: Button
    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var loginApi: LoginApiInformation

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependency()
        setupView()
        setClickToButtons()
    }

    private fun setupDependency() {
        DaggerLoginComponent.builder()
            .activityComponent((requireActivity() as MainActivity).activityComponent)
            .loginModule(LoginModule())
            .build().inject(this)
    }

    private fun setupView() {
        buttonLogin = binding.signInAccountButton
        buttonToRegistrationFragment = binding.goToRegistrationText
    }

    private fun setClickToButtons() {
        buttonToRegistrationFragment.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }

        buttonLogin.setOnClickListener {
            val username = binding.inputEmail.editText?.text.toString()
            val password = binding.InputPassword.editText?.text.toString()
            CoroutineScope(Dispatchers.Main).launch {
                val answerOfLogin = viewModel.loginUserInApp(loginApi = loginApi, userLogin = username, userPassword = password)
                if(answerOfLogin.isValide) {
                    findNavController().setGraph(R.navigation.nav_profile_graph)
                    val bottomNavigationView =
                        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
                    bottomNavigationView.visibility = View.VISIBLE
                }
                else {
                    //TODO: Exception while login
                }
            }
        }
    }

}