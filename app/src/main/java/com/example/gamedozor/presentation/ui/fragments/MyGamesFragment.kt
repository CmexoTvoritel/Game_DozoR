package com.example.gamedozor.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.R
import com.example.gamedozor.databinding.FragmentMyGamesBinding
import com.example.gamedozor.presentation.ui.adapters.MyGamesAdapter
import com.example.gamedozor.presentation.viewmodels.MyGamesViewModel

class MyGamesFragment : Fragment() {

    private var _binding: FragmentMyGamesBinding? = null
    private val binding get() = _binding!!

    private lateinit var myGamesAdapter: MyGamesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MyGamesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        viewModel = ViewModelProvider(this)[MyGamesViewModel::class.java]
        recyclerView = binding.rvMyGames
        myGamesAdapter = MyGamesAdapter(viewModel.addItemsToRV())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = myGamesAdapter
    }

}