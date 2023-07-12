package com.example.gamedozor.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemMyGameLayoutBinding
import com.example.gamedozor.presentation.models.MyGamesModel
import com.example.gamedozor.presentation.ui.viewholders.MyGamesViewHolder

class MyGamesAdapter(private val listMyGames: List<MyGamesModel>): RecyclerView.Adapter<MyGamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGamesViewHolder {
        return MyGamesViewHolder(ItemMyGameLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listMyGames.size
    }

    override fun onBindViewHolder(holder: MyGamesViewHolder, position: Int) {
        with(holder) {
            with(listMyGames[position]) {
                binding.nameOfGame.text = this.nameGame
                binding.textTimeGame.text = this.timeGame
                binding.totalTeams.text = "${this.currentTeams} | ${this.maximumTeams}"
                binding.textDataGame.text = this.dataGame
            }
        }
    }
}