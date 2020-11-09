package com.example.faithandroid.bulletinboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.BulletinboardTextpostBinding
import com.example.faithandroid.models.Post

import com.google.android.material.dialog.MaterialAlertDialogBuilder

class BulletinBoardPostAdapter : ListAdapter<Post, BulletinBoardPostAdapter.BulletinBoardPostViewHolder>(
    DiffCallback
) {
    class BulletinBoardPostViewHolder(private var binding: BulletinboardTextpostBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(post: Post){
            binding.post = post
            binding.executePendingBindings()
            Log.d("lala", binding.bulletinboardOpenButton.text as String)
            binding.bulletinboardOpenButton.setOnClickListener { view: View ->
                MaterialAlertDialogBuilder(binding.root.context)
                    .setTitle(post.title)
                    .setMessage(post.data)
                    .show()
            }



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
    ): BulletinBoardPostViewHolder {


        return BulletinBoardPostViewHolder(BulletinboardTextpostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: BulletinBoardPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)
    }
}