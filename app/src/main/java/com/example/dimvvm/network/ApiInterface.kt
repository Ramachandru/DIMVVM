package com.example.dimvvm.network

import com.example.dimvvm.model.PlayersData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        const val BASE_URL: String = "https://demonuts.com/Demonuts/JsonTest/Tennis/"
    }

    @GET("json_parsing.php")
    suspend fun getPlayersData(): PlayersData
}