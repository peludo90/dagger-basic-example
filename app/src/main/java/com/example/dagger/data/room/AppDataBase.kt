package com.example.dagger.data.room

import android.content.Context
import androidx.room.*
import com.example.dagger.data.Log
import com.example.dagger.data.room.dao.LogDao

@Database(entities = [Log::class], version = DB_VERSION)
@TypeConverters(value = [LocalDateTimeConverter::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun logDao(): LogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    DB_NAME
                ).build().also {
                    INSTANCE = it
                }
            }
    }
}