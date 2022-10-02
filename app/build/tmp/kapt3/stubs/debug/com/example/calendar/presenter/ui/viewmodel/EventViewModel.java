package com.example.calendar.presenter.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.calendar.data.local.db.entity.EventEntity;
import com.example.calendar.data.repo.EventRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/calendar/presenter/ui/viewmodel/EventViewModel;", "Landroidx/lifecycle/ViewModel;", "eventRepo", "Lcom/example/calendar/data/repo/EventRepo;", "(Lcom/example/calendar/data/repo/EventRepo;)V", "setStateEvent", "", "eventState", "Lcom/example/calendar/presenter/ui/viewmodel/EventState;", "app_debug"})
public final class EventViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.calendar.data.repo.EventRepo eventRepo = null;
    
    @javax.inject.Inject()
    public EventViewModel(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.repo.EventRepo eventRepo) {
        super();
    }
    
    public final void setStateEvent(@org.jetbrains.annotations.NotNull()
    com.example.calendar.presenter.ui.viewmodel.EventState eventState) {
    }
}