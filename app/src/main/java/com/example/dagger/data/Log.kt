package com.example.dagger.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dagger.data.room.LOD_MESSAGE
import com.example.dagger.data.room.LOG_DATE
import com.example.dagger.data.room.LOG_TABLE
import java.time.LocalDateTime

@Entity(tableName = LOG_TABLE)
data class Log(
    @ColumnInfo(name = LOD_MESSAGE)
    var message: String = "",
    @PrimaryKey
    @ColumnInfo(name = LOG_DATE)
    var date: LocalDateTime = LocalDateTime.now()
)