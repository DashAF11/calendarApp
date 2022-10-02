package com.example.calendar.di;

import android.app.Application;
import androidx.room.Room;
import com.example.calendar.data.local.db.EventDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/calendar/di/DatabaseModule;", "", "()V", "provideCalendarDatabase", "Lcom/example/calendar/data/local/db/EventDatabase;", "app", "Landroid/app/Application;", "provideEventDao", "Lcom/example/calendar/data/local/db/dao/EventDao;", "db", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.calendar.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.calendar.data.local.db.EventDatabase provideCalendarDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.calendar.data.local.db.dao.EventDao provideEventDao(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.local.db.EventDatabase db) {
        return null;
    }
}