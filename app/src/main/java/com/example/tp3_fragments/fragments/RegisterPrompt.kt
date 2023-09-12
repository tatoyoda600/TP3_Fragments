package com.example.tp3_fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tp3_fragments.R

class RegisterPrompt : Fragment() {
    lateinit var v : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_register_prompt, container, false)
        v.findViewById<Button>(R.id.registerButton).setOnClickListener { registerButtonClick(v) }
        v.findViewById<TextView>(R.id.registerHasAccount).setOnClickListener { loginTextClick(v) }
        return v
    }

    override fun onStart() {
        super.onStart()

        val userField : TextView = v.findViewById(R.id.registerUserInput)
        val user : String = RegisterPromptArgs.fromBundle(requireArguments()).username
        userField.text = user
    }

    fun loginTextClick(view: View) {
        view.findNavController().navigateUp()
        //(activity as FragmentUser).changeFragment(LoginPrompt())
    }

    fun registerButtonClick(view: View) {
        val userField : TextView = view.findViewById(R.id.registerUserInput)
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Register Attempt")
        alert.setMessage("Tried to register '${userField.text}'")
        alert.setPositiveButton("Close", null)
        alert.show()
    }
}