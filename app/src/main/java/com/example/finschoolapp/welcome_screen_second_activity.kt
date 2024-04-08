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
        iWillHelpYouButton.setOnClickListener {
            val navController = Navigation.findNavController(view)

            // переходим к другому графу
            navController.setGraph(R.navigation.navigation_main_menu)

            // переходим к экрану progress_screen
            navController.navigate(R.id.progress_screen)
        }
        return view
    }

}