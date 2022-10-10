package com.example.dimvvm.network

import com.example.dimvvm.database.PlayerListDao
import com.example.dimvvm.model.PlayersData
import com.example.dimvvm.model.PlayersList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayerDataRepository @Inject constructor(
    val apiService: ApiInterface,
    val localDb: PlayerListDao
) {
    suspend fun getPlayersData(): Flow<PlayersData> {
        return flow {
            emit(apiService.getPlayersData())
        }
    }

    suspend fun getPlayersList(): Flow<List<PlayersList>> {
        return flow {
            emit(localDb.getPlayerList())
        }
    }

    fun insertData(player: PlayersList) {
        localDb.insertAll(player)
    }
}