package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation

class accounting_screen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_accounting_screen, container, false)

        val progressScreenButton = view.findViewById<ImageButton>(R.id.from_accounting_to_progress_main_menu)
        progressScreenButton.setOnClickListener {Navigation.findNavController(view).navigate(R.id.action_accounting_screen_to_progress_screen)}
        return view
    }

}