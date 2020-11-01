package com.example.faithandroid

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.network.FaithProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FaithProperty>?){
    val adapter = recyclerView.adapter as FirstNameGridAdapter
    adapter.submitList(data)
}