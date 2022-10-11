package com.example.dimvvm.database

import androidx.room.*
import com.example.dimvvm.model.PlayersList

@Dao
interface PlayerListDao {
    @Query("Select * from playerlist")
    fun getPlayerList(): List<PlayersList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(player: PlayersList)

    @Delete
    fun delete(player: PlayersList)
}