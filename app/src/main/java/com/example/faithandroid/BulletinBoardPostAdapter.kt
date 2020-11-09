package com.example.faithandroid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.TextpostBinding
import com.example.faithandroid.models.Post

import com.example.faithandroid.network.FaithProperty
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.textpost.view.*

class BulletinBoardPostAdapter : ListAdapter<Post, BulletinBoardPostAdapter.BulletinBoardPostViewHolder>(DiffCallback) {
    class BulletinBoardPostViewHolder(private var binding: TextpostBinding):
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