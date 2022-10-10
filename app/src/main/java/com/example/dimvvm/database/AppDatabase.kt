package com.example.dimvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dimvvm.model.PlayersList

@Database(entities = [PlayersList::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPlayerListDao(): PlayerListDao
}