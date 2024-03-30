package com.example.finschoolapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

class email_code_entry : Fragment() {

    val args: email_code_entryArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        System.out.println(args.userMail)
        return inflater.inflate(R.layout.fragment_email_code_entry, container, false)
    }

}