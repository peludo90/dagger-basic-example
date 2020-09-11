package com.example.dagger.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dagger.data.room.AppDataBase
import com.example.dagger.data.room.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun providesRoomDataBase(application: Application): AppDataBase =
        Room.databaseBuilder(
            application,
            AppDataBase::class.java,
            DB_NAME
        ).build()
}