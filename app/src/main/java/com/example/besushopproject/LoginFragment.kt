package com.example.besushopproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<TextView>(R.id.register)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val emailInput = view.findViewById<TextInputLayout>(R.id.emailInputLogin)
        val passwordInput = view.findViewById<TextInputLayout>(R.id.passwordInputLogin)
        //Click listener to open the register fragment by passing the action id
        //to the navController
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_home_dest_to_register_fragment, null)
        }
        //Click Listener first data input is validated and then if every
        //field is full it goes to HomeActivity
        btnLogin.setOnClickListener {
            if (emailInput.editText?.text.toString().isEmpty()|| passwordInput.editText?.text.toString().isEmpty()) {
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, R.string.toast_message, duration)
                toast.show()
            } else {
                findNavController().navigate(R.id.action_start_dest_to_HomeActivity, null)
            }
        }
    }

}