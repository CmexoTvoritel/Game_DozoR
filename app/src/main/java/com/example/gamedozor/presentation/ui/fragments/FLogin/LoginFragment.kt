package com.example.gamedozor.presentation.ui.fragments.FLogin

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
import com.example.gamedozor.data.db.model.UserEntity
import com.example.gamedozor.data.db.repository.UserDao
import com.example.gamedozor.databinding.FragmentLoginBinding
import com.example.gamedozor.presentation.ui.fragments.FLogin.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var buttonToRegistrationFragment: TextView
    private lateinit var buttonLogin: Button
    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setClickToButtons()
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
                val answerOfLogin = viewModel.loginUserInApp(userLogin = username, userPassword = password)
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