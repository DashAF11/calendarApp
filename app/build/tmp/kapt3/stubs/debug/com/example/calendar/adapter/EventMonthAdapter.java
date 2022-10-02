package com.example.calendar.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.calendar.R;
import com.example.calendar.data.local.db.entity.Events;
import com.example.calendar.databinding.ListItemMonthEventLayoutBinding;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/calendar/adapter/EventMonthAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/calendar/adapter/EventMonthAdapter$ViewHolder;", "()V", "eventList", "", "Lcom/example/calendar/data/local/db/entity/Events;", "eventsByMonthAdapter", "Lcom/example/calendar/adapter/EventsByMonthAdapter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "events", "", "toggleEventView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "textView", "Landroid/widget/TextView;", "ViewHolder", "app_debug"})
public final class EventMonthAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.calendar.adapter.EventMonthAdapter.ViewHolder> {
    private java.util.List<com.example.calendar.data.local.db.entity.Events> eventList;
    private com.example.calendar.adapter.EventsByMonthAdapter eventsByMonthAdapter;
    
    @javax.inject.Inject()
    public EventMonthAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.calendar.adapter.EventMonthAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.calendar.data.local.db.entity.Events> events) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.calendar.adapter.EventMonthAdapter.ViewHolder holder, int position) {
    }
    
    private final void toggleEventView(androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/calendar/adapter/EventMonthAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/calendar/databinding/ListItemMonthEventLayoutBinding;", "(Lcom/example/calendar/adapter/EventMonthAdapter;Lcom/example/calendar/databinding/ListItemMonthEventLayoutBinding;)V", "bind", "", "entity", "Lcom/example/calendar/data/local/db/entity/Events;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.calendar.databinding.ListItemMonthEventLayoutBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.calendar.databinding.ListItemMonthEventLayoutBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.calendar.data.local.db.entity.Events entity) {
        }
    }
}