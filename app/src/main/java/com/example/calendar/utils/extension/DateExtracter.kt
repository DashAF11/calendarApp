package com.example.calendar.utils.extension

import android.text.format.DateFormat
import java.util.*

fun getMonthAndDate(timestamp: Long): String {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = timestamp
    return DateFormat.format("MMM dd", calendar).toString()
}

fun getTimeFormat(timestamp: Long): String {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = timestamp
    return DateFormat.format("hh:mm aaa", calendar).toString()
}

fun getDuration(timestamp: Long): String {
    val hours = (timestamp / (1000 * 60 * 60)).toInt()
    val mins = (timestamp / (1000 * 60) % 60).toInt()

    val diff = if (hours != 0) {
        "$hours.$mins hrs"
    } else {
        "$mins min"
    }

    return diff
}

fun getTimeInMillisFormat(
    selectedYear: Int,
    month: String,
    day: String,
    hour: String,
    min: String,
    timeUnit: String
): Long {
    val calendar = Calendar.getInstance();
    calendar[Calendar.YEAR] = selectedYear
    calendar[Calendar.MONTH] = month.toInt()
    calendar[Calendar.DAY_OF_MONTH] = day.toInt()
    calendar[Calendar.HOUR] = hour.toInt()
    calendar[Calendar.MINUTE] = min.toInt()
    calendar[Calendar.SECOND] = 0
    calendar[Calendar.MILLISECOND] = 0

    if (timeUnit == "AM") {
        calendar[Calendar.AM_PM] = 0
    } else if (timeUnit == "PM") {
        calendar[Calendar.AM_PM] = 1
    }

    return calendar.timeInMillis
}