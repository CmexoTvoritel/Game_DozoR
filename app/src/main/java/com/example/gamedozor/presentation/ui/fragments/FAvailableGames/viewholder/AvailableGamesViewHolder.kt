package com.example.gamedozor.presentation.ui.fragments.FAvailableGames.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemAvailableGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.model.AvailableGamesModel

class AvailableGamesViewHolder(val binding: ItemAvailableGameLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    private var clickCallbackSignUp: ((type: AvailableGamesModel) -> Unit)? = null

    fun bind(item: AvailableGamesModel) {
        binding.btnSingUpGame.setOnClickListener {
            clickCallbackSignUp?.invoke(item)
        }
    }

}