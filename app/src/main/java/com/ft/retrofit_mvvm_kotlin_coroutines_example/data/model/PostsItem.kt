package com.ft.retrofit_mvvm_kotlin_coroutines_example.data.model


import com.google.gson.annotations.SerializedName
data class PostsItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)