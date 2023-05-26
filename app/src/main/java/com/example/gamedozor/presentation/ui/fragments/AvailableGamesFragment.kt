package com.example.gamedozor.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.FragmentAvailableGamesBinding
import com.example.gamedozor.presentation.ui.adapters.AvailableGamesAdapter
import com.example.gamedozor.presentation.viewmodels.AvailableGamesViewModel

class AvailableGamesFragment : Fragment() {

    private lateinit var adapter: AvailableGamesAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentAvailableGamesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AvailableGamesViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAvailableGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        viewModel = ViewModelProvider(this)[AvailableGamesViewModel::class.java]
        recyclerView = binding.rvAvailableGames
        adapter = AvailableGamesAdapter(viewModel.addGamesToRV())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

}