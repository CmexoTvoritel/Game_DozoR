package com.example.gamedozor.presentation.ui.fragments.mygames.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gamedozor.databinding.ItemMateLayoutBinding
import com.example.gamedozor.presentation.ui.MateModel
import com.example.gamedozor.presentation.ui.fragments.mygames.viewholder.MatesViewHolder
import java.util.zip.Inflater

class MatesAdapter: ListAdapter<MateModel, MatesViewHolder>(MatesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatesViewHolder {
        return MatesViewHolder(
            ItemMateLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}