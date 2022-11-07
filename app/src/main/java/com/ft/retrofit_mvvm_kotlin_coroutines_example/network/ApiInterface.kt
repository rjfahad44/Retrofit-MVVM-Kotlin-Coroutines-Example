package com.ft.retrofit_mvvm_kotlin_coroutines_example.network


import com.ft.retrofit_mvvm_kotlin_coroutines_example.data.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<Posts>
}