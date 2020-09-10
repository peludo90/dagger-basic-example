package com.example.dagger.di

import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.list.StaticLocalDataSource
import com.example.dagger.data.room.RoomLocalDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface LocalStorageModule {

    @Singleton
    @Binds
    fun bindsRoomLocalDataSource(localDataSource: RoomLocalDataSource): LocalDataSource


    /*@Singleton
    @Binds
    fun bindsStaticLocalDataSource(localDataSource: StaticLocalDataSource): LocalDataSource*/
}