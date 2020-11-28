package com.example.faithandroid

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.adapters.FilteredPostAdapter
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.shoppingCenter.ShoppingCenterGridAdapter

@BindingAdapter("filteredPostData")
fun bindRecyclerViewFilteredPost(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as FilteredPostAdapter
    adapter.submitList(data)
}

@BindingAdapter("postData")
fun bindRecyclerViewPost(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as PostAdapter
    adapter.submitList(data)
}

@BindingAdapter("BillboardListData")
fun bindRecyclerViewBillboard(recyclerView: RecyclerView, data: List<GoalPost>?){
    val adapter = recyclerView.adapter as BillboardGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("AvatarParts")
fun bindRecyclerViewShoppingcenter(recyclerView: RecyclerView, data: List<String>?){
    val adapter = recyclerView.adapter as ShoppingCenterGridAdapter
    adapter.submitList(data)
}