package com.example.dimvvm.model

data class PlayersData(
    val status: Boolean,
    val message: String,
    val data: List<PlayersList>
)

data class PlayersList(
    val id: String,
    val name: String,
    val country: String,
    val city: String,
    val Basel: String,
    val imgURL : String
)
