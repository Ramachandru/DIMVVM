package com.example.dimvvm.di

import android.content.Context
import androidx.room.Room
import com.example.dimvvm.database.AppDatabase
import com.example.dimvvm.database.PlayerListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun getDBInstance(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "Players"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePlayerListDao(appDatabase: AppDatabase): PlayerListDao {
        return appDatabase.getPlayerListDao()
    }
}