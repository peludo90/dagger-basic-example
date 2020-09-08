package com.example.dagger.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(element: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(elements: List<T>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(element: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(elements: List<T>)

    @Delete
    suspend fun delete(element: T)

    @Delete
    suspend fun delete(elements: List<T>)
}