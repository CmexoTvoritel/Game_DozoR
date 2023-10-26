package com.example.gamedozor.presentation.ui.fragments.mygames.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.gamedozor.presentation.ui.fragments.mygames.model.MyGamesModel

class MyGamesDiffCallback: DiffUtil.ItemCallback<MyGamesModel>() {
    override fun areItemsTheSame(oldItem: MyGamesModel, newItem: MyGamesModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyGamesModel, newItem: MyGamesModel): Boolean {
        return oldItem.nameGame == newItem.nameGame
                && oldItem.dataGame == newItem.dataGame
                && oldItem.timeGame == newItem.timeGame
    }
}