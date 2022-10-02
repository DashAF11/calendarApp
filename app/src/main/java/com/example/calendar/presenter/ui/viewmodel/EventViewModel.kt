package com.example.calendar.presenter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.data.repo.EventRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepo: EventRepo
) : ViewModel() {

    fun setStateEvent(eventState: EventState) {
        viewModelScope.launch {
            when (eventState) {
                is EventState.AddEvent -> {
                    viewModelScope.launch {
                        eventRepo.upsertEvent(eventState.event)
                    }
                }

                is EventState.None -> {

                }
            }
        }
    }

}

sealed class EventState {
    class AddEvent(val event: EventEntity) : EventState()
    object None : EventState()
}