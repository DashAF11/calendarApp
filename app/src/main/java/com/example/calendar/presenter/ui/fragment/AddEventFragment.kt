package com.example.calendar.presenter.ui.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calendar.R
import com.example.calendar.data.local.db.entity.EventEntity
import com.example.calendar.databinding.FragmentAddEventBinding
import com.example.calendar.presenter.ui.activity.MainActivity
import com.example.calendar.presenter.ui.viewmodel.EventState
import com.example.calendar.presenter.ui.viewmodel.EventViewModel
import com.example.calendar.utils.extension.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.math.abs

@AndroidEntryPoint
class AddEventFragment : Fragment() {
    private lateinit var binding: FragmentAddEventBinding
    private val eventViewModel: EventViewModel by viewModels({ activity as MainActivity })
    private var calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)
    private val month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DAY_OF_MONTH)
    private val hour = calendar.get(Calendar.HOUR_OF_DAY)
    private val minute = calendar.get(Calendar.MINUTE)
    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDayOfMonth = day
    private var eventDate = ""
    private var timeUnit = ""
    private var startTimeInMillis: Long = 0
    private var endTimeInMilles: Long = 0
    private var eventStartHour = ""
    private var eventStartMin = ""
    private var eventEndHour = ""
    private var eventEndMin = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvMeetingDate.setSafeOnClickListener {
                hideKeyboard()

                val datePickerDialog =
                    DatePickerDialog(
                        requireActivity(), DatePickerDialog.OnDateSetListener
                        { _, year, monthOfYear, dayOfMonth ->
                            val mon: String = if (monthOfYear + 1 < 10) {
                                "0${monthOfYear + 1}"
                            } else {
                                "" + (monthOfYear + 1)
                            }
                            val day: String = if (dayOfMonth < 10) {
                                "0$dayOfMonth"
                            } else {
                                "" + dayOfMonth
                            }
                            eventDate = "$day-$mon-$year"
                            tvMeetingDate.text = eventDate

                            selectedYear = year
                            selectedMonth = mon.toInt()
                            selectedDayOfMonth = day.toInt()

                        }, year, month, day
                    )
                datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
                datePickerDialog.show()
            }
            tvStartTime.setSafeOnClickListener {
                hideKeyboard()
                openTimeDialog(true)
            }

            tvEndTime.setSafeOnClickListener {
                hideKeyboard()
                openTimeDialog(false)
            }

            btnCreate.setSafeOnClickListener {
                when {
                    etMeetingTitle.string.isEmpty() -> {
                        etMeetingTitle.startAnimation(shakeError())
                        toast(getString(R.string.enter_meeting_title))
                    }
                    eventDate.isEmpty() -> {
                        tvMeetingDate.startAnimation(shakeError())
                        toast(getString(R.string.select_meeting_date))
                    }
                    startTimeInMillis <= 0 -> {
                        tvStartTime.startAnimation(shakeError())
                        toast(getString(R.string.select_start_time))
                    }
                    endTimeInMilles <= 0 -> {
                        tvEndTime.startAnimation(shakeError())
                        toast(getString(R.string.select_end_time))
                    }
                    else -> {
                        eventViewModel.setStateEvent(
                            EventState.AddEvent(
                                EventEntity(
                                    eventName = binding.etMeetingTitle.string,
                                    eventMonth = getTimeInMillisFormat(
                                        selectedYear,
                                        selectedMonth.toString(),
                                        selectedDayOfMonth.toString(),
                                        "0",
                                        "0",
                                        "AM"
                                    ),
                                    eventStartTimestamp = startTimeInMillis,
                                    eventEndTimestamp = endTimeInMilles,
                                    eventDiffTimestamp = abs(startTimeInMillis - endTimeInMilles),
                                    eventTimeStamp = startTimeInMillis
                                )
                            )
                        )

                        clearAll()
                    }
                }
            }
        }
    }

    private fun openTimeDialog(isStartTime: Boolean) {
        if (selectedMonth > 0) {
            val timePickerDialog = TimePickerDialog(
                activity,
                { view, hourOfDay, minute ->

                    val datetime = Calendar.getInstance()
                    val c = Calendar.getInstance()
                    datetime[Calendar.MONTH] = month
                    datetime[Calendar.DAY_OF_MONTH] = day
                    datetime[Calendar.HOUR_OF_DAY] = hourOfDay
                    datetime[Calendar.MINUTE] = minute

                    if (selectedMonth == month + 1 && selectedDayOfMonth != day) {
                        var hour = hourOfDay
                        timeUnit = "AM"
                        var mm_precede = ""
                        var hr_precede = ""
                        if (hour >= 12) {
                            timeUnit = "PM"
                            if (hour in 13..23) {
                                hour -= 12
                            } else {
                                hour = 12
                            }
                        } else if (hour == 0) {
                            hour = 12
                        }
                        if (hour < 10) {
                            hr_precede = "0"
                        }
                        if (minute < 10) {
                            mm_precede = "0"
                        }
                        if (isStartTime) {
                            eventStartHour = "$hr_precede$hour"
                            eventStartMin = "$mm_precede$minute"

                            binding.tvStartTime.text = "$eventStartHour:$eventStartMin $timeUnit"

                            startTimeInMillis = getTimeInMillisFormat(
                                selectedYear,
                                selectedMonth.toString(),
                                selectedDayOfMonth.toString(),
                                eventStartHour,
                                eventStartMin,
                                timeUnit,
                            )
                        } else {
                            eventEndHour = "$hr_precede$hour"
                            eventEndMin = "$mm_precede$minute"
                            binding.tvEndTime.text = "$eventEndHour:$eventEndMin $timeUnit"

                            endTimeInMilles = getTimeInMillisFormat(
                                selectedYear,
                                selectedMonth.toString(),
                                selectedDayOfMonth.toString(),
                                eventEndHour,
                                eventEndMin,
                                timeUnit,
                            )
                        }
                    } else {
                        if (datetime.timeInMillis <= c.timeInMillis) {
                            toast(getString(R.string.dont_select_past_time))
                        } else {
                            var hour = hourOfDay
                            timeUnit = "AM"
                            var mm_precede = ""
                            var hr_precede = ""
                            if (hour >= 12) {
                                timeUnit = "PM"
                                if (hour in 13..23) {
                                    hour -= 12
                                } else {
                                    hour = 12
                                }
                            } else if (hour == 0) {
                                hour = 12
                            }
                            if (hour < 10) {
                                hr_precede = "0"
                            }
                            if (minute < 10) {
                                mm_precede = "0"
                            }
                            if (isStartTime) {
                                eventStartHour = "$hr_precede$hour"
                                eventStartMin = "$mm_precede$minute"

                                binding.tvStartTime.text =
                                    "$eventStartHour:$eventStartMin $timeUnit"

                                startTimeInMillis = getTimeInMillisFormat(
                                    selectedYear,
                                    selectedMonth.toString(),
                                    selectedDayOfMonth.toString(),
                                    eventStartHour,
                                    eventStartMin,
                                    timeUnit,
                                )
                            } else {
                                eventEndHour = "$hr_precede$hour"
                                eventEndMin = "$mm_precede$minute"
                                binding.tvEndTime.text = "$eventEndHour:$eventEndMin $timeUnit"

                                endTimeInMilles = getTimeInMillisFormat(
                                    selectedYear,
                                    selectedMonth.toString(),
                                    selectedDayOfMonth.toString(),
                                    eventEndHour,
                                    eventEndMin,
                                    timeUnit,
                                )
                            }
                        }
                    }
                }, hour, minute, false
            )
            timePickerDialog.show()
        } else {
            binding.tvMeetingDate.startAnimation(shakeError())
            toast(getString(R.string.select_meeting_date))
        }
    }

    private fun clearAll() {
        binding.apply {
            etMeetingTitle.setText("")
            tvMeetingDate.text = getString(R.string.select_date)
            tvStartTime.text = getString(R.string.start)
            tvEndTime.text = getString(R.string.end)
        }

        selectedYear = 0
        selectedMonth = 0
        eventDate = ""
        startTimeInMillis = 0
        endTimeInMilles = 0
    }
}