package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class login_first_activity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_first_activity, container, false)

        val register_button = view.findViewById<Button>(R.id.register_button_first_activity)
        register_button.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_login_first_activity_to_registration_screen_activity) }

        val login_button = view.findViewById<Button>(R.id.login_button_first_activity)
        login_button.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_login_first_activity_to_welcome_screen_first_activity) }

        return view
    }

}