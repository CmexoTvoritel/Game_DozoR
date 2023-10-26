package com.example.gamedozor.presentation.ui.fragments.availablegames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamedozor.databinding.FragmentAvailableGamesBinding
import com.example.gamedozor.presentation.ui.fragments.availablegames.adapter.AvailableGamesAdapter
import com.example.gamedozor.presentation.ui.fragments.availablegames.viewmodel.AvailableGamesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AvailableGamesFragment : Fragment() {

    private lateinit var binding: FragmentAvailableGamesBinding

    private val viewModel: AvailableGamesViewModel by viewModels()

    private var adapter = AvailableGamesAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAvailableGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupState()
    }

    private fun setupRV() = binding.apply {
        rvAvailableGames.adapter = adapter
        rvAvailableGames.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupState() = lifecycleScope.launch {
        viewModel.getGamesList()
        viewModel.games.collect { item ->
            adapter.submitList(item)
        }
    }

    private fun bindButtons() {
        //TODO sing up to game function
    }

}