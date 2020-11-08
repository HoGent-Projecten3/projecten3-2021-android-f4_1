package com.example.faithandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.TextpostBinding
import com.example.faithandroid.models.Post

import com.example.faithandroid.network.FaithProperty

class BulletinBoardPostAdapter : ListAdapter<Post, BulletinBoardPostAdapter.BulletinBoardPostViewHolder>(DiffCallback) {
    class BulletinBoardPostViewHolder(private var binding: TextpostBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(post: Post){
            binding.post = post
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BulletinBoardPostAdapter.BulletinBoardPostViewHolder {
        return BulletinBoardPostViewHolder(TextpostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: BulletinBoardPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)
    }
}