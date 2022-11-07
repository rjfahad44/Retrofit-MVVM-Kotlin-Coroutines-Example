package com.ft.retrofit_mvvm_kotlin_coroutines_example.network

import com.ft.retrofit_mvvm_kotlin_coroutines_example.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}