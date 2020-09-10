package com.example.dagger.data.list

import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.Log
import javax.inject.Inject

class StaticLocalDataSource @Inject constructor() : LocalDataSource {

    private val logs = mutableListOf<Log>()

    override suspend fun save(log: Log) {
        logs.add(0, log)
    }

    override suspend fun getAll(): List<Log> {
        return logs
    }

    override suspend fun clear() {
        logs.clear()
    }
}