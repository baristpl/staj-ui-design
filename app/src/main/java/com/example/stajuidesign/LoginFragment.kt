package com.example.stajuidesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

const val EMAIL = "dummy@univenn.com"
const val PASSWORD = "123456"
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailInput = view.findViewById<EditText>(R.id.email_edit)
        val passwordInput = view.findViewById<EditText>(R.id.password_edit)
        val signInButton = view.findViewById<Button>(R.id.sign_in_button)

        signInButton.setOnClickListener {
            val eMail = emailInput.text.toString()
            val password = passwordInput.text.toString()
            var passwordAuthentication = false
            var eMailAuthentication = false

            if (eMail == EMAIL){
                eMailAuthentication = true
                if (password == PASSWORD){
                    passwordAuthentication = true
                    findNavController().navigate(R.id.home_fragment_des)
                }else Toast.makeText(activity,
                    "INCORRECT PASSWORD!", Toast.LENGTH_LONG).show();
            }else Toast.makeText(activity,
                "UNREGISTERED EMAIL!", Toast.LENGTH_LONG).show();

        }
    }
}