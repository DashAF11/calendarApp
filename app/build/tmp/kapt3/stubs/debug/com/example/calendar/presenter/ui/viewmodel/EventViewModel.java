package com.example.calendar.presenter.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.calendar.data.local.db.entity.EventEntity;
import com.example.calendar.data.local.db.entity.Events;
import com.example.calendar.data.repo.EventRepo;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/example/calendar/presenter/ui/viewmodel/EventViewModel;", "Landroidx/lifecycle/ViewModel;", "eventRepo", "Lcom/example/calendar/data/repo/EventRepo;", "(Lcom/example/calendar/data/repo/EventRepo;)V", "_monthEvents", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/calendar/data/local/db/entity/Events;", "monthEvents", "Landroidx/lifecycle/LiveData;", "getMonthEvents", "()Landroidx/lifecycle/LiveData;", "setStateEvent", "", "eventState", "Lcom/example/calendar/presenter/ui/viewmodel/EventState;", "app_debug"})
public final class EventViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.calendar.data.repo.EventRepo eventRepo = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.calendar.data.local.db.entity.Events>> _monthEvents = null;
    
    @javax.inject.Inject()
    public EventViewModel(@org.jetbrains.annotations.NotNull()
    com.example.calendar.data.repo.EventRepo eventRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.calendar.data.local.db.entity.Events>> getMonthEvents() {
        return null;
    }
    
    public final void setStateEvent(@org.jetbrains.annotations.NotNull()
    com.example.calendar.presenter.ui.viewmodel.EventState eventState) {
    }
}