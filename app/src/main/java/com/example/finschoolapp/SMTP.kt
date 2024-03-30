package com.example.finschoolapp

import android.util.Log
import java.net.Authenticator
import java.net.PasswordAuthentication
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class SMTP{
    fun sendMail(mailAdress: String, message: String){
        if (isValidEmail(mailAdress)) {
            val senderMail = "finschool68@gmail.com"
            val senderMailPassword = "bcfvdhfohepzvptq"
            val host = "smtp.gmail.com"

            val properties = System.getProperties()

            properties.put("mail.smtp.host", host)
            properties.put("mail.smtp.port", "25")
            properties.put("mail.smtp.auth", "true")
            properties.put("mail.smtp.starttls.enable", "true")

            val session = javax.mail.Session.getInstance(properties, object : Authenticator() {
                @Override
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(senderMail, senderMailPassword)
                }

            })

            val mimeMessage = MimeMessage(session)
            mimeMessage.addRecipient(Message.RecipientType.TO, InternetAddress(mailAdress))

            mimeMessage.setFrom(InternetAddress(senderMail))
            mimeMessage.setSubject("FinSchool")
            mimeMessage.setText(message)

            Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    Log.e("SendMail", "Error sending email: ${e.message}")
                }
            }.start()
        }
    }
    fun randomNum(): String {
        val currentTime = System.currentTimeMillis().toString()
        return currentTime.takeLast(6)
    }
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}