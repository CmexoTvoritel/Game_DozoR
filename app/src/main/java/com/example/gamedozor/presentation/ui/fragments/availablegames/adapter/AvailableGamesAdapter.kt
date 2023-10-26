package com.example.gamedozor.presentation.ui.fragments.availablegames.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemAvailableGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.availablegames.model.AvailableGamesModel
import com.example.gamedozor.presentation.ui.fragments.availablegames.viewholder.AvailableGamesViewHolder

class AvailableGamesAdapter(): ListAdapter<AvailableGamesModel, AvailableGamesViewHolder>(AvailableGamesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableGamesViewHolder {
        return AvailableGamesViewHolder(
            ItemAvailableGameLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AvailableGamesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


}