package com.example.dimvvm.model

sealed class PlayerResult {
    data class Success(val playesrData: PlayersData) : PlayerResult()

    data class Error(val errorMsg: String) : PlayerResult()

    object Loading : PlayerResult()
}