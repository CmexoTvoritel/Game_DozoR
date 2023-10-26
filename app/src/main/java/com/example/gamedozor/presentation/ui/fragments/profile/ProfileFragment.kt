package com.example.gamedozor.presentation.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gamedozor.databinding.FragmentProfileBinding
import com.example.gamedozor.presentation.ui.fragments.profile.model.ErrorType
import com.example.gamedozor.presentation.ui.fragments.profile.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupButtons()
    }

    private fun setupUI() = binding.apply {
        lifecycleScope.launch {
            val infoAboutUser = viewModel.getDataAboutUser()
            withContext(Dispatchers.Main) {
                if(infoAboutUser.errorMessage == ErrorType.SUCCESS) {
                    fullnameProfile.text = infoAboutUser.name + " " + infoAboutUser.surname
                    totalGamesText.text = infoAboutUser.numOfGames.toString()
                    totalWinsText.text = infoAboutUser.winGames.toString()
                } else {
                    //TODO: Alert about it
                }
            }
        }
    }

    private fun setupButtons() = binding.apply {
        settingsImageButton.setOnClickListener {
            //TODO:
        }
    }

}