package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class welcome_screen_first_activity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome_screen_first_activity, container, false)

        val whatToDoButton = view.findViewById<Button>(R.id.what_to_do_button)
        whatToDoButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_welcome_screen_first_activity_to_welcome_screen_second_activity) }

        return view
    }

}