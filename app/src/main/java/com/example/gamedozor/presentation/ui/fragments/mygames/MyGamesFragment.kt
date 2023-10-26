package com.example.gamedozor.presentation.ui.fragments.mygames

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentMyGamesBinding
import com.example.gamedozor.databinding.PopupMenuTeamLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.mygames.adapter.MatesAdapter
import com.example.gamedozor.presentation.ui.fragments.mygames.adapter.MyGamesAdapter
import com.example.gamedozor.presentation.ui.fragments.mygames.viewmodel.MyGamesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyGamesFragment: Fragment() {

    private lateinit var binding: FragmentMyGamesBinding
    private lateinit var popupBinding: PopupMenuTeamLayoutBinding

    private lateinit var popupWindow: PopupWindow

    private var adapter = MyGamesAdapter()
    private var matesAdapter = MatesAdapter()
    private val viewModel: MyGamesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMyGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupState()
    }

    private fun setupRV() = binding.apply {
        adapter.showTeamClickCallback = {type ->
            showPopupMenu()
        }
        rvMyGames.adapter = adapter
        rvMyGames.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupState() = lifecycleScope.launch {
        viewModel.getGameList()
        viewModel.gameList.collect {item ->
            adapter.submitList(item)
        }
    }

    private fun showPopupMenu() {
        val popupView = layoutInflater.inflate(R.layout.popup_menu_team_layout, null)
        popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        popupBinding = PopupMenuTeamLayoutBinding.bind(popupView)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        //TODO: Background for this case (opacity = 0.7 and dark gray)
        showTeam()
        setupPopupButtons()
    }

    private fun showTeam() = lifecycleScope.launch {
        viewModel.getTeammatesList()
        popupBinding.mtRVTeam.adapter = matesAdapter
        popupBinding.mtRVTeam.layoutManager = LinearLayoutManager(requireContext())
        viewModel.matesList.collect { item ->
            matesAdapter.submitList(item)
        }
    }

    private fun setupPopupButtons() = popupBinding.apply {
        mtCloseButton.setOnClickListener {
            popupWindow.dismiss()
        }
    }
}