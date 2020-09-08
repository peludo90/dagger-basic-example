package com.example.dagger.data

interface LocalDataSource {

    suspend fun save(log: Log)

    suspend fun getAll(): List<Log>

    suspend fun clear()
}