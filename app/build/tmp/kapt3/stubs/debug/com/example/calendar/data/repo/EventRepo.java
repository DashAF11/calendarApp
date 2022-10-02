package com.example.calendar.data.repo;

import com.example.calendar.data.local.db.dao.EventDao;
import com.example.calendar.data.local.db.entity.EventEntity;
import com.example.calendar.data.local.db.entity.Events;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fJ%\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0010\"\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/calendar/data/repo/EventRepo;", "", "eventDao", "Lcom/example/calendar/data/local/db/dao/EventDao;", "(Lcom/example/calendar/data/local/db/dao/EventDao;)V", "getAllEventMonths", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/calendar/data/local/db/entity/Events;", "getEventByMonths", "Lcom/example/calendar/data/local/db/entity/EventEntity;", "month", "", "upsertEvent", "", "event", "", "([Lcom/example/calendar/data/local/db/entity/EventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class EventRepo {
    private final com.example.calendar.data.local.db.dao.EventDao eventDao = null;
    
    @javax.inject.Inject()
    public EventRepo(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.local.db.dao.EventDao eventDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object upsertEvent(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.local.db.entity.EventEntity[] event, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calendar.data.local.db.entity.Events>> getAllEventMonths() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.calendar.data.local.db.entity.EventEntity>> getEventByMonths(long month) {
        return null;
    }
}