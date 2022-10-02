package com.example.calendar.di

import android.app.Application
import androidx.room.Room
import com.example.calendar.data.local.db.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCalendarDatabase(
        app: Application
    ) = Room.databaseBuilder(
        app,
        EventDatabase::class.java,
        "Calendar"
    ).fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideEventDao(db: EventDatabase) = db.getEventDao()
}