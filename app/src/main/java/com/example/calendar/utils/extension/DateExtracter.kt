package com.example.calendar.utils.extension

import java.util.*

fun getTimeInHourMin(timeInMillis: Long): String {
    val millis: Long = timeInMillis
    val hours = (millis / (1000 * 60 * 60)).toInt()
    val mins = (millis / (1000 * 60)).toInt() % 60
    return "$hours:$mins"
}

fun getMonthName(month: Int): String {
    val arrayOfMonth =
        arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    return arrayOfMonth[month - 1]
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