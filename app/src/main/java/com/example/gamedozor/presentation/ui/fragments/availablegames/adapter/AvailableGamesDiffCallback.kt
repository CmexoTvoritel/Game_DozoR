package com.example.gamedozor.presentation.ui.fragments.availablegames.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.gamedozor.presentation.ui.fragments.availablegames.model.AvailableGamesModel

class AvailableGamesDiffCallback: DiffUtil.ItemCallback<AvailableGamesModel>() {
    override fun areItemsTheSame(
        oldItem: AvailableGamesModel,
        newItem: AvailableGamesModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: AvailableGamesModel,
        newItem: AvailableGamesModel
    ): Boolean {
        return oldItem.nameGame == newItem.nameGame
                && oldItem.dataGame == newItem.dataGame
                && oldItem.timeGame == newItem.timeGame
                && oldItem.description == newItem.description
    }
}