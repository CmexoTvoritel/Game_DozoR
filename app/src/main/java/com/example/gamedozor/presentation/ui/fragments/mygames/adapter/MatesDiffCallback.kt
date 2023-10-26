package com.example.gamedozor.presentation.ui.fragments.mygames.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.gamedozor.presentation.ui.MateModel

class MatesDiffCallback: DiffUtil.ItemCallback<MateModel>() {
    override fun areItemsTheSame(oldItem: MateModel, newItem: MateModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MateModel, newItem: MateModel): Boolean {
        return oldItem.nickname == newItem.nickname
    }
}