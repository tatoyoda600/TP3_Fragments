package com.example.tp3_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3_fragments.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}