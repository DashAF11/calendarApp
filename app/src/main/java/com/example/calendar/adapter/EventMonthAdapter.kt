package com.example.calendar.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.R
import com.example.calendar.data.local.db.entity.Events
import com.example.calendar.databinding.ListItemMonthEventLayoutBinding
import com.example.calendar.utils.extension.drawableEnd
import com.example.calendar.utils.extension.getMonthAndDate
import com.example.calendar.utils.extension.gone
import com.example.calendar.utils.extension.visible
import javax.inject.Inject

class EventMonthAdapter @Inject constructor() :
    RecyclerView.Adapter<EventMonthAdapter.ViewHolder>() {
    private var eventList: MutableList<Events> = mutableListOf()
    private lateinit var eventsByMonthAdapter: EventsByMonthAdapter

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventMonthAdapter.ViewHolder {
        val binding =
            ListItemMonthEventLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(events: List<Events>) {
        this.eventList = events as MutableList<Events>
        Log.e("eventList", "$eventList")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = eventList.size

    override fun onBindViewHolder(holder: EventMonthAdapter.ViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ViewHolder(private val binding: ListItemMonthEventLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: Events) {

            binding.apply {
                tvMonth.text = getMonthAndDate(entity.day)

                tvMonth.setOnClickListener {
                    toggleEventView(rvEvents, tvMonth)
                }

                eventsByMonthAdapter = EventsByMonthAdapter()
                rvEvents.adapter = eventsByMonthAdapter

                eventsByMonthAdapter.setEventsByMonthItems(eventList[adapterPosition].dayEvents)
            }
        }
    }

    private fun toggleEventView(recyclerView: RecyclerView, textView: TextView) {
        if (recyclerView.visibility == View.VISIBLE) {
            recyclerView.gone()
            textView.drawableEnd(R.drawable.ic_arrow_down)
        } else {
            recyclerView.visible()
            textView.drawableEnd(R.drawable.ic_arrow_up_24)
        }
    }
}