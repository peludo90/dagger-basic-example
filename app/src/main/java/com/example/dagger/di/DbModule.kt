package com.example.dagger.di

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
    fun providesRoomDataBase(context: Context): AppDataBase =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            DB_NAME
        ).build()
}