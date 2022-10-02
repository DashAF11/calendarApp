package com.example.calendar.presenter.ui.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.calendar.R;
import com.example.calendar.data.local.db.entity.EventEntity;
import com.example.calendar.databinding.FragmentAddEventBinding;
import com.example.calendar.presenter.ui.activity.MainActivity;
import com.example.calendar.presenter.ui.viewmodel.EventState;
import com.example.calendar.presenter.ui.viewmodel.EventViewModel;
import com.example.calendar.utils.extension.*;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/example/calendar/presenter/ui/fragment/AddEventFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/calendar/databinding/FragmentAddEventBinding;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "day", "", "endTimeInMilles", "", "eventDate", "", "eventEndHour", "eventEndMin", "eventStartHour", "eventStartMin", "eventViewModel", "Lcom/example/calendar/presenter/ui/viewmodel/EventViewModel;", "getEventViewModel", "()Lcom/example/calendar/presenter/ui/viewmodel/EventViewModel;", "eventViewModel$delegate", "Lkotlin/Lazy;", "hour", "minute", "month", "selectedDayOfMonth", "selectedMonth", "selectedYear", "startTimeInMillis", "timeUnit", "year", "clearAll", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "openTimeDialog", "isStartTime", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AddEventFragment extends androidx.fragment.app.Fragment {
    private com.example.calendar.databinding.FragmentAddEventBinding binding;
    private final kotlin.Lazy eventViewModel$delegate = null;
    private java.util.Calendar calendar;
    private final int year = 0;
    private final int month = 0;
    private final int day = 0;
    private final int hour = 0;
    private final int minute = 0;
    private int selectedYear = 0;
    private int selectedMonth = 0;
    private int selectedDayOfMonth;
    private java.lang.String eventDate = "";
    private java.lang.String timeUnit = "";
    private long startTimeInMillis = 0L;
    private long endTimeInMilles = 0L;
    private java.lang.String eventStartHour = "";
    private java.lang.String eventStartMin = "";
    private java.lang.String eventEndHour = "";
    private java.lang.String eventEndMin = "";
    
    public AddEventFragment() {
        super();
    }
    
    private final com.example.calendar.presenter.ui.viewmodel.EventViewModel getEventViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openTimeDialog(boolean isStartTime) {
    }
    
    private final void clearAll() {
    }
}