package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class email_code_entry : Fragment() {

    val args: email_code_entryArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val smtp = SMTP()
        val randomNum = smtp.randomNum()
        smtp.sendMail(args.userMail, "Привет, ${args.userName}! Вот твой код: $randomNum")

        val view = inflater.inflate(R.layout.fragment_email_code_entry, container, false)
        val sendCodeButton = view.findViewById<Button>(R.id.send_code_button)
        val errorMessageTextView = view.findViewById<TextView>(R.id.error_message_code)

        sendCodeButton.setOnClickListener{

            val codeInput = view.findViewById<EditText>(R.id.input_code_field)?.text.toString().replace(" ", "")

            if (codeInput.equals(randomNum)){
                Navigation.findNavController(view).navigate(R.id.action_email_code_entry_to_successfully_registration_screen)
            }
            else{
                view.findViewById<EditText>(R.id.input_code_field).setBackgroundResource(R.drawable.background_error)
                errorMessageTextView.setText("Неверный код")
                errorMessageTextView.visibility = View.VISIBLE
            }
        }

        return view
    }

}