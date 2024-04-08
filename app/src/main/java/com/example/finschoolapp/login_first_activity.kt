package com.example.finschoolapp

import android.content.Intent
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

        val registerButton = view.findViewById<Button>(R.id.register_button_first_activity)
        registerButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_login_first_activity_to_registration_screen_activity) }

        val loginButton = view.findViewById<Button>(R.id.login_button_first_activity)
        loginButton.setOnClickListener {
            val username = "УЖЕ СМЕШАРИК"
            if (username.equals("УЖЕ СМЕШАРИК")){
                val navController = Navigation.findNavController(view)

                // переходим к другому графу
                navController.setGraph(R.navigation.navigation_main_menu)

                // переходим к экрану progress_screen
                navController.navigate(R.id.progress_screen)
            }
            else{
                Navigation.findNavController(view).navigate(R.id.action_login_first_activity_to_welcome_screen_first_activity)
            }

        }

        val recoverPasswordButton = view.findViewById<Button>(R.id.recover_password_button)
        recoverPasswordButton.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_login_first_activity_to_recover_password) }
        return view
    }

}