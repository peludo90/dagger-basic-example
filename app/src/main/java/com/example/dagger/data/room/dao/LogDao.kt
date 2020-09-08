package com.example.dagger.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.dagger.data.Log
import com.example.dagger.data.room.LOG_DATE
import com.example.dagger.data.room.LOG_TABLE

@Dao
interface LogDao : BaseDao<Log> {

    @Query("select * from $LOG_TABLE order by  $LOG_DATE desc")
    suspend fun getAll(): List<Log>

    @Query("delete from $LOG_TABLE")
    suspend fun deleteAll()
}