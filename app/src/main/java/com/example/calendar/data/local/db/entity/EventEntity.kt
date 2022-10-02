package com.example.calendar.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventTable")
data class EventEntity(
    @ColumnInfo(name = "event_name") val eventName: String,
    @ColumnInfo(name = "event_date") val eventMonth: String,
    @ColumnInfo(name = "event_start_time") val eventStartTime: String,
    @ColumnInfo(name = "event_end_time") val eventEndTime: String,
    @ColumnInfo(name = "event_duration") val eventDuration: String,
    @PrimaryKey @ColumnInfo(name = "event_timestamp") val eventTimeStamp: String
)