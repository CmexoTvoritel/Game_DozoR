package com.example.gamedozor.data.api.games.model

import com.google.gson.annotations.SerializedName

data class GameModel(
    val name: String,
    val legend: String,
    @SerializedName("datetime_start")
    val datetimeStart: String,
    @SerializedName("datetime_end")
    val datetimeEnd: String,
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: Int,
)
