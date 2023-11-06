package com.packagename.updatewithroom

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api:Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}