package com.example.calendar.presenter.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.data.local.db.entity.Events
import com.example.calendar.data.repo.EventRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepo: EventRepo
) : ViewModel() {

    val monthEvents: LiveData<List<Events>>
        get() = _monthEvents

    private val _monthEvents: MutableLiveData<List<Events>> =
        MutableLiveData()

    fun setStateEvent(eventState: EventState) {
        viewModelScope.launch {
            when (eventState) {
                is EventState.AddEvent -> {
                    viewModelScope.launch {
                        eventRepo.upsertEvent(eventState.event)
                    }
                }

                is EventState.GetEventMonths -> {
                    eventRepo.getAllEventMonths().onEach {
                        if (it.isNotEmpty())
                            _monthEvents.value = it
                    }.launchIn(this)
                }
            }
        }
    }
}

sealed class EventState {
    class AddEvent(val event: EventEntity) : EventState()
    object GetEventMonths : EventState()
}