package com.ft.retrofit_mvvm_kotlin_coroutines_example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ft.retrofit_mvvm_kotlin_coroutines_example.repository.PostRepository

@Suppress("UNCHECKED_CAST")
class PostViewModelFactory(private val postRepository: PostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            PostViewModel(this.postRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}