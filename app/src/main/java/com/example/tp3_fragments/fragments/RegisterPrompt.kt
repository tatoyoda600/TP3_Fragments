package com.example.tp3_fragments.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.tp3_fragments.MainActivity
import com.example.tp3_fragments.R
import com.example.tp3_fragments.databinding.FragmentRegisterPromptBinding

class RegisterPrompt : Fragment() {
    lateinit var v : View
    lateinit var binding : FragmentRegisterPromptBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterPromptBinding.inflate(inflater, container, false)
        //v = inflater.inflate(R.layout.fragment_register_prompt, container, false)
        v = binding.root
        binding.registerButton.setOnClickListener { registerButtonClick(v) }
        binding.registerHasAccount.setOnClickListener { loginTextClick(v) }
        return v
    }

    override fun onStart() {
        super.onStart()

        val user : String = RegisterPromptArgs.fromBundle(requireArguments()).username
        binding.registerUserInput.setText(user)
    }

    fun loginTextClick(view: View) {
        view.findNavController().navigateUp()
    }

    fun registerButtonClick(view: View) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Register Attempt")
        alert.setMessage("Tried to register '${binding.registerUserInput.text}'")
        alert.setPositiveButton("Close", null)
        alert.setPositiveButton("Close") { dialogInterface, i ->
            val switchActivity = Intent(context, MainActivity::class.java)
            startActivity(switchActivity)
        }
        alert.show()
    }
}