package com.example.calendar.presenter.ui.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.calendar.R

class EventFragmentDirections private constructor() {
  companion object {
    fun actionEventFragmentToAddEventFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_eventFragment_to_addEventFragment)
  }
}
