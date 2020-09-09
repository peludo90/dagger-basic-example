package com.example.dagger.data.list

import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.Log

object StaticLocalDataSource : LocalDataSource {

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

   /* companion object {
        @Volatile
        private var INSTANCE: StaticLocalDataSource? = null

        fun getInstance(): StaticLocalDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: StaticLocalDataSource()
            }
    }*/
}