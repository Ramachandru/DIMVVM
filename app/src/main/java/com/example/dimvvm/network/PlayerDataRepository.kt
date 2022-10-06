package com.example.dimvvm.network

import com.example.dimvvm.model.PlayersData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlayerDataRepository @Inject constructor(val apiService: ApiInterface) {
    suspend fun getPlayersData(): Flow<PlayersData> {
        return flow {
            emit(apiService.getPlayersData())
        }
    }
}