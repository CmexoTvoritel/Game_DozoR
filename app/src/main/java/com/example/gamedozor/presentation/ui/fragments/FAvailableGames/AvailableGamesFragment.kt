package com.example.gamedozor.presentation.ui.fragments.FAvailableGames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.FragmentAvailableGamesBinding
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.adapter.AvailableGamesAdapter
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.viewmodel.AvailableGamesViewModel

class AvailableGamesFragment : Fragment() {

    private lateinit var adapter: AvailableGamesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentAvailableGamesBinding

    private val viewModel: AvailableGamesViewModel by lazy {
        ViewModelProvider(this)[AvailableGamesViewModel::class.java]
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAvailableGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        recyclerView = binding.rvAvailableGames
        adapter = AvailableGamesAdapter(viewModel.addGamesToRV())
        bindButtons()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun bindButtons() {
        adapter.clickCallbackSignUp = { _ ->
            //TODO sing up to game function
        }
    }

}