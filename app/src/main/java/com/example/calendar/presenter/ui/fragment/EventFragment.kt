package com.example.calendar.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.calendar.R
import com.example.calendar.adapter.EventMonthAdapter
import com.example.calendar.databinding.FragmentEventFragmentBinding
import com.example.calendar.presenter.ui.activity.MainActivity
import com.example.calendar.presenter.ui.viewmodel.EventState
import com.example.calendar.presenter.ui.viewmodel.EventViewModel
import com.example.calendar.utils.extension.navigate
import com.example.calendar.utils.extension.setSafeOnClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventFragmentBinding
    private lateinit var eventMonthAdapter: EventMonthAdapter

    private val eventViewModel: EventViewModel by viewModels({ activity as MainActivity })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        eventMonthAdapter = EventMonthAdapter()
        binding.rvMonthEvents.adapter = eventMonthAdapter

        binding.tvAddCalendarEvent.setSafeOnClickListener {
            navigate(R.id.addEventFragment)
        }

        eventViewModel.setStateEvent(EventState.GetEventMonths)
    }

    private fun setObservers() {
        eventViewModel.monthEvents.observe(viewLifecycleOwner) {
            eventMonthAdapter.setItems(it)
        }
    }
}