package com.example.gamedozor.presentation.ui.fragments.chats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gamedozor.databinding.ItemGameChatLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.chats.model.ChatsModel
import com.example.gamedozor.presentation.ui.fragments.chats.viewholder.ChatsViewHolder

class ChatsAdapter: ListAdapter<ChatsModel, ChatsViewHolder>(ChatsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(
            ItemGameChatLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}