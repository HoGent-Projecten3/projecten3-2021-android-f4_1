package com.example.faithandroid

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post

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