package com.example.calendar.presenter.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.calendar.data.local.db.entity.EventEntity;
import com.example.calendar.data.repo.EventRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/calendar/presenter/ui/viewmodel/EventState;", "", "()V", "AddEvent", "None", "Lcom/example/calendar/presenter/ui/viewmodel/EventState$AddEvent;", "Lcom/example/calendar/presenter/ui/viewmodel/EventState$None;", "app_debug"})
public abstract class EventState {
    
    private EventState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/calendar/presenter/ui/viewmodel/EventState$AddEvent;", "Lcom/example/calendar/presenter/ui/viewmodel/EventState;", "event", "Lcom/example/calendar/data/local/db/entity/EventEntity;", "(Lcom/example/calendar/data/local/db/entity/EventEntity;)V", "getEvent", "()Lcom/example/calendar/data/local/db/entity/EventEntity;", "app_debug"})
    public static final class AddEvent extends com.example.calendar.presenter.ui.viewmodel.EventState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.calendar.data.local.db.entity.EventEntity event = null;
        
        public AddEvent(@org.jetbrains.annotations.NotNull()
        com.example.calendar.data.local.db.entity.EventEntity event) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.calendar.data.local.db.entity.EventEntity getEvent() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/calendar/presenter/ui/viewmodel/EventState$None;", "Lcom/example/calendar/presenter/ui/viewmodel/EventState;", "()V", "app_debug"})
    public static final class None extends com.example.calendar.presenter.ui.viewmodel.EventState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.calendar.presenter.ui.viewmodel.EventState.None INSTANCE = null;
        
        private None() {
            super();
        }
    }
}