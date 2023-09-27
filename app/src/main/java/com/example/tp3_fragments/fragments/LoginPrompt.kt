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
import com.example.tp3_fragments.databinding.FragmentLoginPromptBinding

class LoginPrompt : Fragment() {
    lateinit var v: View
    lateinit var binding : FragmentLoginPromptBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginPromptBinding.inflate(inflater, container, false)
        //v = inflater.inflate(R.layout.fragment_login_prompt, container, false)
        v= binding.root
        binding.loginButton.setOnClickListener { loginButtonClick(v) }
        binding.loginCreateAccount.setOnClickListener { registerTextClick(v) }
        return v
    }

    fun registerTextClick(view: View) {
        view.findNavController().navigate(LoginPromptDirections.actionLoginPromptToRegisterPrompt(binding.loginUserInput.text.toString()))
    }

    fun loginButtonClick(view: View) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Login Attempt")
        alert.setMessage("Tried to log in to '${binding.loginUserInput.text}'")
        alert.setPositiveButton("Close") { dialogInterface, i ->
            val switchActivity = Intent(context, MainActivity::class.java)
            startActivity(switchActivity)
        }
        alert.show()
    }
}