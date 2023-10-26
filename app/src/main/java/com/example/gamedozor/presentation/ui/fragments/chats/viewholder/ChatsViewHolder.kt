package com.example.gamedozor.presentation.ui.fragments.chats.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemGameChatLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.chats.model.ChatsModel

class ChatsViewHolder(private val binding: ItemGameChatLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ChatsModel) = binding.apply {
        nameOfGame.text = item.nameGame
        totalTeams.text = "${item.currentTeams} | ${item.maximumTeams}"
        textDataGame.text = item.dataGame
        textTimeGame.text = item.timeGame
    }
}