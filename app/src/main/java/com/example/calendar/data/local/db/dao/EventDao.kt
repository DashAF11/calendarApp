package com.example.calendar.data.local.db.dao

import androidx.room.*
import com.example.calendar.data.local.db.entity.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertEvent(vararg event: EventEntity)

    @Query("SELECT * FROM EventTable ")
    fun getAllEventMonth(): Flow<EventEntity>

    @Query("SELECT * FROM EventTable WHERE event_month =:month")
    fun getAllEventByMonth(month: Int): Flow<List<EventEntity>>

    @Delete
    suspend fun delete(event: EventEntity)
}