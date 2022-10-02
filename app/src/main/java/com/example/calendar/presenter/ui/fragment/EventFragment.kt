package com.example.calendar.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.calendar.R
import com.example.calendar.databinding.FragmentEventFragmentBinding
import com.example.calendar.presenter.ui.viewmodel.EventViewModel
import com.example.calendar.utils.extension.navigate
import com.example.calendar.utils.extension.setSafeOnClickListener

class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventFragmentBinding
    private lateinit var viewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvAddCalendarEvent.setSafeOnClickListener {
            navigate(R.id.addEventFragment)
        }
    }
}