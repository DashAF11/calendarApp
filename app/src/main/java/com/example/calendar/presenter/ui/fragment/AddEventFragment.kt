package com.example.calendar.presenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calendar.R
import com.example.calendar.databinding.FragmentAddEventBinding
import com.example.calendar.utils.extension.navigate
import com.example.calendar.utils.extension.setSafeOnClickListener

class AddEventFragment : Fragment() {
    private lateinit var binding: FragmentAddEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        binding.btnCreate.setSafeOnClickListener {
            navigate(R.id.eventFragment)
        }
    }
}