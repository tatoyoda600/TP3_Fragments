package com.example.tp3_fragments.services

import com.example.tp3_fragments.models.Cat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("x-api-key: /1SOco/DosZF9KCLmIp1kQ==23RDMdBU8JINhLfG")
    @GET("cats")
    fun getData(@Query("min_weight") minWeight: Float, @Query("offset") count: Int) : Call<List<Cat>>
}