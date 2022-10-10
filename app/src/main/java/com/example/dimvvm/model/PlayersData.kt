package com.example.dimvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class PlayersData(
    val status: Boolean,
    val message: String,
    val data: List<PlayersList>
)

@Entity(tableName = "playerlist")
data class PlayersList(
    @PrimaryKey(autoGenerate = true )
    var id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "image_url")
    val imgURL: String
)
