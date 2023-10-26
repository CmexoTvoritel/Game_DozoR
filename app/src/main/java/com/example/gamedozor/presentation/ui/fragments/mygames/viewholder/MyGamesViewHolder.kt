package com.example.gamedozor.presentation.ui.fragments.mygames.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemMyGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.mygames.model.MyGamesModel

class MyGamesViewHolder(private val binding: ItemMyGameLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    var showTeamClickCallback: ((type: MyGamesModel) -> Unit)? = null

    fun bind(item: MyGamesModel) = binding.apply {
        nameOfGame.text = item.nameGame
        totalTeams.text = "${item.currentTeams} | ${item.maximumTeams}"
        textDataGame.text = item.dataGame
        textTimeGame.text = item.timeGame
        btnTeam.setOnClickListener {
            showTeamClickCallback?.invoke(item)
        }
    }
}