package com.ft.retrofit_mvvm_kotlin_coroutines_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ft.retrofit_mvvm_kotlin_coroutines_example.data.adapter.RvAdapter
import com.ft.retrofit_mvvm_kotlin_coroutines_example.databinding.ActivityMainBinding
import com.ft.retrofit_mvvm_kotlin_coroutines_example.network.ApiInterface
import com.ft.retrofit_mvvm_kotlin_coroutines_example.network.ApiUtilities
import com.ft.retrofit_mvvm_kotlin_coroutines_example.repository.PostRepository
import com.ft.retrofit_mvvm_kotlin_coroutines_example.viewmodel.PostViewModel
import com.ft.retrofit_mvvm_kotlin_coroutines_example.viewmodel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: RvAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val repository = PostRepository(apiInterface)
        viewModel = ViewModelProvider(this, PostViewModelFactory(repository))[PostViewModel::class.java]

        binding.rv.layoutManager = LinearLayoutManager(this)
        adapter = RvAdapter()
        binding.rv.adapter = adapter

        viewModel.postsList.observe(this) {
            Log.d("GET", "Get Data : ${it.toString()}")
            adapter.update(it)
        }
    }
}