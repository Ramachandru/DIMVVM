package com.example.dimvvm.di

import android.content.Context
import com.example.dimvvm.network.ApiInterface
import com.example.dimvvm.network.ApiInterface.Companion.BASE_URL
import com.example.dimvvm.presentaion.adapter.PlayerListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}

@Module
@InstallIn(ActivityComponent::class)
object AppDataModule {

    @Provides
    fun provideAdapter(@ActivityContext context: Context): PlayerListAdapter =
        PlayerListAdapter(context)

}

