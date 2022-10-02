package com.example.calendar.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.databinding.ListItemEventLayoutBinding
import com.example.calendar.utils.extension.getDuration
import com.example.calendar.utils.extension.getTimeFormat
import javax.inject.Inject

class EventsByMonthAdapter @Inject constructor() :
    RecyclerView.Adapter<EventsByMonthAdapter.ViewHolder>() {
    private var eventList: MutableList<EventEntity> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventsByMonthAdapter.ViewHolder {
        val binding =
            ListItemEventLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setEventsByMonthItems(events: List<EventEntity>) {
        this.eventList = events as MutableList<EventEntity>
        Log.e("setEventsByMonthItems", "$eventList")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventsByMonthAdapter.ViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ViewHolder(private val binding: ListItemEventLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(entity: EventEntity) {
            binding.tvEventTitle.text = entity.eventName
            binding.tvEventTime.text =
                "${getTimeFormat(entity.eventStartTimestamp)} to ${getTimeFormat(entity.eventEndTimestamp)}"
            binding.tvDuration.text = getDuration(entity.eventDiffTimestamp)
        }
    }
}