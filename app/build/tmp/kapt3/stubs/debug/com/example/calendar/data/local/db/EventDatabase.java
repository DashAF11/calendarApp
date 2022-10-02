package com.example.calendar.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.calendar.data.local.db.dao.EventDao;
import com.example.calendar.data.local.db.entity.EventEntity;

@androidx.room.TypeConverters(value = {com.example.calendar.data.local.db.DBTypeConverters.class})
@androidx.room.Database(entities = {com.example.calendar.data.local.db.entity.EventEntity.class}, version = 1, exportSchema = true)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/calendar/data/local/db/EventDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getEventDao", "Lcom/example/calendar/data/local/db/dao/EventDao;", "app_debug"})
public abstract class EventDatabase extends androidx.room.RoomDatabase {
    
    public EventDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.calendar.data.local.db.dao.EventDao getEventDao();
}