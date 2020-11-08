package com.example.faithandroid

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.TextPost
import com.example.faithandroid.network.FaithProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FaithProperty>?){
    val adapter = recyclerView.adapter as FirstNameGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData")
fun bindRecyclerViewBulletinboard(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as BulletinBoardPostAdapter
    adapter.submitList(data)
}