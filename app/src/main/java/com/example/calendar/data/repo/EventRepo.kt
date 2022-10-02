package com.example.calendar.data.repo

import com.example.calendar.data.local.db.dao.EventDao
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.data.local.db.entity.Events
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class EventRepo @Inject constructor(
    private val eventDao: EventDao
) {
    suspend fun upsertEvent(vararg event: EventEntity) =
        eventDao.upsertEvent(*event)

    fun getAllEventMonths(): Flow<List<Events>> {

        val eventsList = emptyList<Events>().toMutableList()
        val channel = Channel<List<Events>>()

        CoroutineScope(Dispatchers.Default).launch {
            val events = async { eventDao.getAllEventMonth() }.await()

            events.onEach {
                val res = it.distinctBy { entityMonth -> entityMonth.eventMonth }
                res.forEach { months ->
                    eventsList.add(
                        Events(
                            day = months.eventMonth
                        )
                    )
                }

                it.map { eventEntity ->
                    eventsList.map { list ->
                        if (list.day == eventEntity.eventMonth)
                            list.dayEvents.add(
                                EventEntity(
                                    eventName = eventEntity.eventName,
                                    eventDiffTimestamp = eventEntity.eventDiffTimestamp,
                                    eventEndTimestamp = eventEntity.eventEndTimestamp,
                                    eventStartTimestamp = eventEntity.eventStartTimestamp,
                                    eventTimeStamp = eventEntity.eventTimeStamp,
                                    eventMonth = eventEntity.eventMonth
                                )
                            )
                    }
                }

                channel.send(eventsList)
            }.launchIn(this)
        }
        return channel.consumeAsFlow()
    }
}
