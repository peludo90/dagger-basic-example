package com.example.dagger.data.room

import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.Log
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(private val appDataBase: AppDataBase) :
    LocalDataSource {

    override suspend fun save(log: Log) {
        appDataBase.logDao().save(log)
    }

    override suspend fun getAll(): List<Log> {
        return appDataBase.logDao().getAll()
    }

    override suspend fun clear() {
        appDataBase.logDao().deleteAll()
    }
}