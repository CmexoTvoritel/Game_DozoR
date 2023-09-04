package com.example.gamedozor.presentation.ui.fragments.FAvailableGames.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedozor.databinding.ItemAvailableGameLayoutBinding
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.model.AvailableGamesModel
import com.example.gamedozor.presentation.ui.fragments.FAvailableGames.viewholder.AvailableGamesViewHolder

class AvailableGamesAdapter(private val listOfGames: List<AvailableGamesModel>): RecyclerView.Adapter<AvailableGamesViewHolder>() {

    var clickCallbackSignUp: ((type: AvailableGamesModel) -> Unit)? = null

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
                holder.bind(this)
            }
        }
    }

    private fun generateStringForTeams(currTeams: Int, maxTeams: Int) = "$currTeams | $maxTeams"
}