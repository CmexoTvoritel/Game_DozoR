package com.example.gamedozor.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userLogin: String,
    val userPassword: String,
    val alwaysLogin: Boolean,
)
