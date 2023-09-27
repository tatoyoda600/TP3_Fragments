package com.example.tp3_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3_fragments.databinding.ActivityMainBinding
import com.example.tp3_fragments.models.User
import com.example.tp3_fragments.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}