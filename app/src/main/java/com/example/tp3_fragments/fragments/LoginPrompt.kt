package com.example.tp3_fragments.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.example.tp3_fragments.MainActivity
import com.example.tp3_fragments.R

class LoginPrompt : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_login_prompt, container, false)
        v.findViewById<Button>(R.id.loginButton).setOnClickListener { loginButtonClick(v) }
        v.findViewById<TextView>(R.id.loginCreateAccount).setOnClickListener { registerTextClick(v) }
        return v
    }

    fun registerTextClick(view: View) {
        val username : TextView = view.findViewById(R.id.loginUserInput)
        view.findNavController().navigate(LoginPromptDirections.actionLoginPromptToRegisterPrompt(username.text.toString()))
    }

    fun loginButtonClick(view: View) {
        val userField : TextView = view.findViewById(R.id.loginUserInput)
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Login Attempt")
        alert.setMessage("Tried to log in to '${userField.text}'")
        alert.setPositiveButton("Close") { dialogInterface, i ->
            val switchActivity = Intent(context, MainActivity::class.java)
            startActivity(switchActivity)
        }
        alert.show()
    }
}