package com.example.calendar.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calendar.R
import com.example.calendar.databinding.FragmentEventFragmentBinding
import com.example.calendar.utils.extension.navigate
import com.example.calendar.utils.extension.setSafeOnClickListener

class EventFragment : Fragment() {
    private lateinit var binding: FragmentEventFragmentBinding

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