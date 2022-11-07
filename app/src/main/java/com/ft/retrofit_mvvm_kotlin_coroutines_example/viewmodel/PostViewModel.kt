package com.ft.retrofit_mvvm_kotlin_coroutines_example.viewmodel



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ft.retrofit_mvvm_kotlin_coroutines_example.data.model.Posts
import com.ft.retrofit_mvvm_kotlin_coroutines_example.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPosts()
        }
    }

    val postsList: MutableLiveData<Posts> = postRepository.allPosts
    val loading = MutableLiveData<Boolean>()


}