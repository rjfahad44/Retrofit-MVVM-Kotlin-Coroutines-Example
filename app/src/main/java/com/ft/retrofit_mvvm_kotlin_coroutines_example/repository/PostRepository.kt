package com.ft.retrofit_mvvm_kotlin_coroutines_example.repository


import androidx.lifecycle.MutableLiveData
import com.ft.retrofit_mvvm_kotlin_coroutines_example.data.model.Posts
import com.ft.retrofit_mvvm_kotlin_coroutines_example.network.ApiInterface

class PostRepository(private val apiInterface: ApiInterface) {

    private val postsList = MutableLiveData<Posts>()
    val allPosts: MutableLiveData<Posts> = postsList

    suspend fun getPosts() {
        val result = apiInterface.getPosts()
        if (result.body()!= null){
            postsList.postValue(result.body())
        }
    }

}