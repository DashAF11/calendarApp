package com.example.calendar.utils.extension

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Runnable

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.toast(message: String) = runOnUIThread { context.toast(message) }

fun Fragment.runOnUIThread(action: Runnable) = activity?.runOnUiThread(action)

fun Fragment.navigate(@IdRes resId: Int) =
    try {
        findNavController().navigate(resId)
    } catch (e: IllegalArgumentException) {
        Log.d("navigate:", "${e.message}")
    }





