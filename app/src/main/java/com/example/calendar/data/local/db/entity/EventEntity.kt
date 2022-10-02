package com.example.calendar.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventTable")
data class EventEntity(
    @ColumnInfo(name = "event_name") val eventName: String,
    @ColumnInfo(name = "event_month") val eventMonth: Long,
    @ColumnInfo(name = "event_start_time") val eventStartTimestamp: Long,
    @ColumnInfo(name = "event_end_time") val eventEndTimestamp: Long,
    @ColumnInfo(name = "event_diff_time") val eventDiffTimestamp: Long,
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "event_timestamp") val eventTimeStamp: Long
)

data class Events(
    val day : Long,
    val dayEvents : MutableList<EventEntity> = emptyList<EventEntity>().toMutableList()
)