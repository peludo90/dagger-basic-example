package com.example.dagger.data.room

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

const val DB_VERSION = 1
const val DB_NAME = "DaggerTest.db"

const val LOG_TABLE = "logs"
const val LOG_DATE = "date"
const val LOD_MESSAGE = "message"

const val LOCALDATETIME_FORMAT = "dd-MM-yyyy HH:mm"


class LocalDateTimeConverter {
    private val parseFormat = DateTimeFormatter.ofPattern(LOCALDATETIME_FORMAT)

    @TypeConverter
    fun toLocalDateTime(value: Long?): LocalDateTime? = if (value != null) {
        LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault())
    } else {
        null
    }

    @TypeConverter
    fun toStringValue(value: LocalDateTime?): Long? {
        return value?.toInstant(ZoneOffset.UTC)?.toEpochMilli()
    }
}