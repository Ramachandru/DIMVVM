package com.example.dimvvm

import com.example.dimvvm.model.PlayersList

object SavedDataForDetails {
    lateinit var playerList: List<PlayersList>
    fun setUpData(playerList: List<PlayersList>) {
        SavedDataForDetails.playerList = playerList
    }

    fun getPlayerListForDatails(): List<PlayersList> {
        return playerList
    }
}