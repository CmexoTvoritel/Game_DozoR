package com.example.gamedozor.presentation.ui.fragments.FProfile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.gamedozor.databinding.FragmentProfileBinding
import com.example.gamedozor.presentation.ui.fragments.FProfile.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var lName: TextView
    private lateinit var lNickName: TextView
    private lateinit var lAge: TextView
    private lateinit var lCity: TextView
    private lateinit var lHobbies: TextView
    private lateinit var lAboutUser: TextView
    private lateinit var lNumOfGames: TextView
    private lateinit var lWinGames: TextView
    private lateinit var settingsButton: ImageView

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        showInformation()
        setupButtons()
    }

    private fun setupUI() {
        lName = binding.fullnameProfile
        lNickName = binding.nicknameProfile
        lAge = binding.ageTitleText
        lCity = binding.townTitleText
        lHobbies = binding.hobbiesTitleText
        lAboutUser = binding.aboutMeTitleText
        lNumOfGames = binding.totalGamesText
        lWinGames = binding.totalWinsText
        settingsButton = binding.settingsImageButton
    }

    @SuppressLint("SetTextI18n")
    private fun showInformation() = CoroutineScope(Dispatchers.IO).launch {
        val authToken: String = "" //TODO: GET FROM DB AND USE VIEWMODEL FOR THAT SHIT

        val infoAboutUser = viewModel.getDataAboutUser(authToken = authToken)
        withContext(Dispatchers.Main) {
            lName.text = infoAboutUser.name + " " + infoAboutUser.surname
            lNumOfGames.text = infoAboutUser.numOfGames.toString()
            lWinGames.text = infoAboutUser.winGames.toString()
        }
    }

    private fun setupButtons() {
        settingsButton.setOnClickListener {
            //TODO:
        }
    }

}