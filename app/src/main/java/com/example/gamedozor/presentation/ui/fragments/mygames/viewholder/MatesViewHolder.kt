package com.example.gamedozor.presentation.ui.fragments.mygames.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemMateLayoutBinding
import com.example.gamedozor.presentation.ui.MateModel

class MatesViewHolder(private var binding: ItemMateLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MateModel) = binding.apply {
        itNickName.text = item.nickname
    }
}