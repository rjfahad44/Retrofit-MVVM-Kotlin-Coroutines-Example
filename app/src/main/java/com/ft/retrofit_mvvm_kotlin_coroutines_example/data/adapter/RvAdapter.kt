package com.ft.retrofit_mvvm_kotlin_coroutines_example.data.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ft.retrofit_mvvm_kotlin_coroutines_example.data.model.Posts
import com.ft.retrofit_mvvm_kotlin_coroutines_example.databinding.RvItemBinding

class RvAdapter: RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private val itemList = Posts()

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: Posts){
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //return LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvUserId.text = itemList[position].userId.toString()
        holder.binding.tvId.text = itemList[position].id.toString()
        holder.binding.tvTitle.text = itemList[position].title.toString()
        holder.binding.tvBody.text = itemList[position].body.toString()
    }

    override fun getItemCount(): Int = itemList.size
}