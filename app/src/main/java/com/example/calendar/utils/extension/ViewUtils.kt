package com.example.calendar.utils.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val EditText.string: String
    get() = text?.toString()?.trim() ?: ""

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context?.toast(message: String) {
    this?.let { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun shakeError(): TranslateAnimation {
    val shake = TranslateAnimation(0f, 30f, 0f, 0f)
    shake.duration = 300
    shake.interpolator = CycleInterpolator(2f)
    return shake
}

fun TextView.drawableEnd(@DrawableRes id: Int) =
    setCompoundDrawablesWithIntrinsicBounds(0, 0, id, 0)




