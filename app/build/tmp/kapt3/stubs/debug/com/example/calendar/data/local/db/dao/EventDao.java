package com.example.calendar.data.local.db.dao;

import androidx.room.*;
import com.example.calendar.data.local.db.entity.EventEntity;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J%\u0010\r\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/calendar/data/local/db/dao/EventDao;", "", "delete", "", "event", "Lcom/example/calendar/data/local/db/entity/EventEntity;", "(Lcom/example/calendar/data/local/db/entity/EventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEventByMonth", "Lkotlinx/coroutines/flow/Flow;", "", "month", "", "getAllEventMonth", "upsertEvent", "", "([Lcom/example/calendar/data/local/db/entity/EventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EventDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object upsertEvent(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.local.db.entity.EventEntity[] event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM EventTable ")
    public abstract kotlinx.coroutines.flow.Flow<com.example.calendar.data.local.db.entity.EventEntity> getAllEventMonth();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM EventTable WHERE event_month =:month")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.calendar.data.local.db.entity.EventEntity>> getAllEventByMonth(int month);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.local.db.entity.EventEntity event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}