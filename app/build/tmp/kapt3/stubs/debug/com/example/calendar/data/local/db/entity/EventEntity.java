package com.example.calendar.data.local.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "EventTable")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/example/calendar/data/local/db/entity/EventEntity;", "", "eventName", "", "eventMonth", "", "eventStartTimestamp", "eventEndTimestamp", "eventDiffTimestamp", "eventTimeStamp", "(Ljava/lang/String;JJJJJ)V", "getEventDiffTimestamp", "()J", "getEventEndTimestamp", "getEventMonth", "getEventName", "()Ljava/lang/String;", "getEventStartTimestamp", "getEventTimeStamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class EventEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "event_name")
    private final java.lang.String eventName = null;
    @androidx.room.ColumnInfo(name = "event_month")
    private final long eventMonth = 0L;
    @androidx.room.ColumnInfo(name = "event_start_time")
    private final long eventStartTimestamp = 0L;
    @androidx.room.ColumnInfo(name = "event_end_time")
    private final long eventEndTimestamp = 0L;
    @androidx.room.ColumnInfo(name = "event_diff_time")
    private final long eventDiffTimestamp = 0L;
    @androidx.room.ColumnInfo(name = "event_timestamp")
    @androidx.room.PrimaryKey(autoGenerate = false)
    private final long eventTimeStamp = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.calendar.data.local.db.entity.EventEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, long eventMonth, long eventStartTimestamp, long eventEndTimestamp, long eventDiffTimestamp, long eventTimeStamp) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public EventEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, long eventMonth, long eventStartTimestamp, long eventEndTimestamp, long eventDiffTimestamp, long eventTimeStamp) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventName() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getEventMonth() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getEventStartTimestamp() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getEventEndTimestamp() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getEventDiffTimestamp() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long getEventTimeStamp() {
        return 0L;
    }
}