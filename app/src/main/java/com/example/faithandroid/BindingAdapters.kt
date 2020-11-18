package com.example.faithandroid

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.faithandroid.backpack.BackpackPostAdapter
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.bulletinboard.BulletinBoardPostAdapter
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.network.FaithProperty
import com.example.faithandroid.treasureChest.TreasureChestPostAdapter

@BindingAdapter("listData")
fun bindRecyclerViewBulletinboard(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as BulletinBoardPostAdapter
      adapter.submitList(data)
}

@BindingAdapter("BillboardListData")
fun bindRecyclerViewBillboard(recyclerView: RecyclerView, data: List<GoalPost>?){
    val adapter = recyclerView.adapter as BillboardGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("TreasurechestlistData")
fun bindRecyclerViewTreasurechest(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as TreasureChestPostAdapter
    adapter.submitList(data)
}

@BindingAdapter("BackpacklistData")
fun bindRecyclerViewBackpack(recyclerView: RecyclerView, data: List<Post>?){
    val adapter = recyclerView.adapter as BackpackPostAdapter
    adapter.submitList(data)
}