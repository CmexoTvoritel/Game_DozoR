package com.example.gamedozor.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemAvailableGameLayoutBinding
import com.example.gamedozor.presentation.models.AvailableGamesModel
import com.example.gamedozor.presentation.ui.viewholders.AvailableGamesViewHolder

class AvailableGamesAdapter(private val listOfGames: List<AvailableGamesModel>): RecyclerView.Adapter<AvailableGamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableGamesViewHolder {
        return AvailableGamesViewHolder(ItemAvailableGameLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listOfGames.size
    }

    override fun onBindViewHolder(holder: AvailableGamesViewHolder, position: Int) {
        with(holder) {
            with(listOfGames[position]) {
                binding.nameOfGame.text = this.nameGame
                binding.textDataGame.text = this.dataGame
                binding.textTimeGame.text = this.timeGame
                binding.totalTeams.text = generateStringForTeams(this.currentTeams, this.maximumTeams)
            }
        }
    }

    private fun generateStringForTeams(currTeams: Int, maxTeams: Int) = currTeams.toString() + " | " + maxTeams.toString()
}