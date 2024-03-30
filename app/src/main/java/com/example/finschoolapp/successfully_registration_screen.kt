package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class successfully_registration_screen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_successfully_registration_screen, container, false)
        val letsStudyButton = view.findViewById<Button>(R.id.button_okey_lets_stdudy)
        letsStudyButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_successfully_registration_screen_to_welcome_screen_first_activity)
        }
        return view
    }

}