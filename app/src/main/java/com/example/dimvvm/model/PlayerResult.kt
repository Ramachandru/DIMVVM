package com.example.dimvvm.model

sealed class PlayerResult {
    data class Success(val playersList: List<PlayersList>) : PlayerResult()

    data class Error(val errorMsg: String) : PlayerResult()

    object Loading : PlayerResult()
}