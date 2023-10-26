package com.example.gamedozor.presentation.ui.fragments.availablegames.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemAvailableGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.availablegames.model.AvailableGamesModel

class AvailableGamesViewHolder(val binding: ItemAvailableGameLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    private var clickCallbackSignUp: ((type: AvailableGamesModel) -> Unit)? = null

    fun bind(item: AvailableGamesModel) = binding.apply {
        nameOfGame.text = item.nameGame
        textDataGame.text = item.dataGame
        textTimeGame.text = item.timeGame
        totalTeams.text = "${item.currentTeams} | ${item.maximumTeams}"
        textGameDescription.text = item.description
        btnSingUpGame.setOnClickListener {
            clickCallbackSignUp?.invoke(item)
        }
    }

}