package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation

class progress_screen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_progress_screen, container, false)

        val accountingButton = view.findViewById<ImageButton>(R.id.from_progress_to_accounting_main_menu)
        accountingButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_progress_screen_to_accounting_screen) }

        return view
    }
}