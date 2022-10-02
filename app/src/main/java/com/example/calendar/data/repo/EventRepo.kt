package com.example.calendar.data.repo

import com.example.calendar.data.local.db.dao.EventDao
import com.example.calendar.data.local.db.entity.EventEntity
import javax.inject.Inject

class EventRepo @Inject constructor(
    private val eventDao: EventDao
) {
    suspend fun upsertEvent(vararg event: EventEntity) =
        eventDao.upsertEvent(*event)
}
