package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class welcome_screen_second_activity : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome_screen_second_activity, container, false)

        val iWillHelpYouButton = view.findViewById<Button>(R.id.i_will_help_you_button)
        iWillHelpYouButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_welcome_screen_second_activity_to_progress_screen) }
        return view
    }

}