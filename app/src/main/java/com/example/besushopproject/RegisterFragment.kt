package com.example.besushopproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_register, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<TextView>(R.id.registerButton)
        val email = view.findViewById<TextInputLayout>(R.id.emailInput)
        val password= view.findViewById<TextInputLayout>(R.id.passwordInput)
        val phone = view.findViewById<TextInputLayout>(R.id.phoneInput)
        val name = view.findViewById<TextInputLayout>(R.id.fullName)
        //function to check if data is not complete
        fun dataIsEmpty() : Boolean= (email.editText?.text.toString().isEmpty()||password.editText?.text.toString().isEmpty()
            ||phone.editText?.text.toString().isEmpty()||name.editText?.text.toString().isEmpty())
        //ClickListener first calls the funcion dataIsEmpty
        button?.setOnClickListener {
            //If any input is empty It will throw a Toast
            if(dataIsEmpty()){
          Toast.makeText(context, "Debe completar todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                //Every input was fill up then it goes to Home Fragment again In order
                    // to continue with the Login process
                findNavController().navigate(R.id.action_register_fragment_to_home_dest, null)
            }

        }


        }
    }

