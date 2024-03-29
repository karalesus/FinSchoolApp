package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class registration_screen_activity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration_screen_activity, container, false)

        val retutnToLoginActivityButton = view.findViewById<Button>(R.id.i_have_account_button)
        retutnToLoginActivityButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_registration_screen_activity_to_login_first_activity) }

        val registerButton = view.findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_registration_screen_activity_to_email_code_entry) }
        return view
    }


}