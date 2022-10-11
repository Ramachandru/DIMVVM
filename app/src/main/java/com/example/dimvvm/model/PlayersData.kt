package com.example.dimvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

data class PlayersData(
    val status: Boolean,
    val message: String,
    val data: List<PlayersList>
)

@Entity(
    tableName = "playerlist",
    /*foreignKeys = [ForeignKey(
        entity = PlayersData::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("auth_id"),
        onDelete = ForeignKey.CASCADE
    )]*/
)
data class PlayersList(
    @PrimaryKey(autoGenerate = true)
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
