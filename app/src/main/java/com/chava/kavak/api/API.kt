package com.chava.kavak.api

import com.chava.kavak.Model.Citizens
import retrofit2.Call
import retrofit2.http.GET

public interface BrastleWarkService {
    @GET("main/data.json")
    fun getGnomes(): Call<Citizens>
}