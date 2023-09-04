package com.example.gamedozor.presentation.ui.fragments.FMyGames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.FragmentMyGamesBinding
import com.example.gamedozor.presentation.ui.fragments.FMyGames.adapter.MyGamesAdapter
import com.example.gamedozor.presentation.ui.fragments.FMyGames.viewmodel.MyGamesViewModel

class MyGamesFragment : Fragment() {

    private lateinit var binding: FragmentMyGamesBinding

    private lateinit var myGamesAdapter: MyGamesAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MyGamesViewModel by lazy {
        ViewModelProvider(this)[MyGamesViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMyGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        recyclerView = binding.rvMyGames
        myGamesAdapter = MyGamesAdapter(viewModel.addItemsToRV())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = myGamesAdapter
    }

}