package com.example.gamedozor.presentation.ui.fragments.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamedozor.databinding.FragmentChatsBinding
import com.example.gamedozor.presentation.ui.fragments.chats.adapter.ChatsAdapter
import com.example.gamedozor.presentation.ui.fragments.chats.viewmodel.ChatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatsFragment : Fragment() {

    private lateinit var binding: FragmentChatsBinding

    private var adapter = ChatsAdapter()
    private val viewModel: ChatsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupState()
    }

    private fun setupRV() = binding.apply {
        fcRecyclerView.adapter = adapter
        fcRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupState() = lifecycleScope.launch {
        viewModel.getChatsList()
        viewModel.listChats.collect { item ->
            adapter.submitList(item)
        }
    }

}