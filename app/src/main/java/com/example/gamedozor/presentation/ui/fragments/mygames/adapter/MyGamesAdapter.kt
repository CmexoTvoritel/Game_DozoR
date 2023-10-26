package com.example.gamedozor.presentation.ui.fragments.mygames.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gamedozor.databinding.ItemMyGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.mygames.model.MyGamesModel
import com.example.gamedozor.presentation.ui.fragments.mygames.viewholder.MyGamesViewHolder

class MyGamesAdapter(): ListAdapter<MyGamesModel, MyGamesViewHolder>(MyGamesDiffCallback()) {

    var showTeamClickCallback: ((type: MyGamesModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGamesViewHolder {
        return MyGamesViewHolder(ItemMyGameLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyGamesViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.showTeamClickCallback = showTeamClickCallback
    }
}