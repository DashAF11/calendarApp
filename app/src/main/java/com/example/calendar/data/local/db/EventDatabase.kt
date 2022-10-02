package com.example.calendar.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.calendar.data.local.db.dao.EventDao
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.data.local.db.typeConverters.DBTypeConverters

@Database(
    entities = [EventEntity::class],
    version = 1,
    exportSchema = true
)

@TypeConverters(DBTypeConverters::class)
abstract class EventDatabase : RoomDatabase() {
    abstract fun getEventDao(): EventDao
}
