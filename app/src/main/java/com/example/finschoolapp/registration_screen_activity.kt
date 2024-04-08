//package com.example.finschoolapp
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.core.os.bundleOf
//import androidx.navigation.Navigation
//
//class registration_screen_activity : Fragment() {
//
//    fun setErrorDesign(view: View, editText: Int) {
//        view.findViewById<EditText>(editText).setBackgroundResource(R.drawable.background_error)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view =
//            inflater.inflate(R.layout.fragment_registration_screen_activity, container, false)
//
//        val returnToLoginActivityButton = view.findViewById<Button>(R.id.i_have_account_button)
//        returnToLoginActivityButton.setOnClickListener {
//            Navigation.findNavController(view)
//                .navigate(R.id.action_registration_screen_activity_to_login_first_activity)
//        }
//
//        val registerButton = view.findViewById<Button>(R.id.register_button)
//        registerButton.setOnClickListener {
//
//            val userName = view.findViewById<EditText>(R.id.user_name)?.text.toString()
//            val userLogin = view.findViewById<EditText>(R.id.user_login)?.text.toString()
//            val userMail = view.findViewById<EditText>(R.id.user_mail)?.text.toString()
//            val userPassword1 = view.findViewById<EditText>(R.id.user_password1)?.text.toString()
//            val userPassword2 = view.findViewById<EditText>(R.id.user_password2)?.text.toString()
//            val errorMessageTextView = view.findViewById<TextView>(R.id.error_message_password)
//
//            if (userName.isNotEmpty() && userLogin.isNotEmpty() && userMail.isNotEmpty() && userPassword1.isNotEmpty() && userPassword2.isNotEmpty()) {
//                if (userPassword1.equals(userPassword2)) {
//                    if (userPassword1.length > 8) {
//                        val action =
//                            registration_screen_activityDirections.actionRegistrationScreenActivityToEmailCodeEntry(
//                                userName,
//                                userLogin,
//                                userMail,
//                                userPassword1
//                            )
//                        Navigation.findNavController(view).navigate(action)
//                    } else {
//                        setErrorDesign(view, R.id.user_password1)
//                        setErrorDesign(view, R.id.user_password2)
//                        errorMessageTextView.text = "Пароль должен содержать не менее 8 символов"
//                        errorMessageTextView.visibility = View.VISIBLE
//                    }
//
//                } else {
//                    setErrorDesign(view, R.id.user_password1)
//                    setErrorDesign(view, R.id.user_password2)
//                    errorMessageTextView.text = "Пароли не совпадают"
//                    errorMessageTextView.visibility = View.VISIBLE
//                }
//            }else{
//                if (userName.isBlank()) setErrorDesign(view, R.id.user_name)
//                if (userLogin.isBlank()) setErrorDesign(view, R.id.user_login)
//                if (userMail.isBlank()) setErrorDesign(view, R.id.user_mail)
//                if (userPassword1.isBlank()) setErrorDesign(view, R.id.user_password1)
//                if (userPassword2.isBlank()) setErrorDesign(view, R.id.user_password2)
//                errorMessageTextView.text = "Заполните пропуски"
//                errorMessageTextView.visibility = View.VISIBLE
//            }
//
//        }
//        return view
//
//    }
//}