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
import com.example.stajuidesign.databinding.ActivityMainBinding
import com.example.stajuidesign.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

const val EMAIL = "dummy@univenn.com"
const val PASSWORD = "123456"

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailInput = binding.emailEdit
        val passwordInput = binding.passwordEdit
        val signInButton = binding.signInButton

        signInButton.setOnClickListener {
            val eMail = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (eMail == EMAIL) {
                if (password == PASSWORD) {
                    findNavController().navigate(R.id.home_fragment_des)
                } else Toast.makeText(
                    activity,
                    "INCORRECT PASSWORD!", Toast.LENGTH_LONG
                ).show();
            } else Toast.makeText(
                activity,
                "UNREGISTERED EMAIL!", Toast.LENGTH_LONG
            ).show();
        }
    }
}