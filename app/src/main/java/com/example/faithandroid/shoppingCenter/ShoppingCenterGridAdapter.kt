package com.example.faithandroid.shoppingCenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.ShoppingcenterBinding

class ShoppingCenterGridAdapter : ListAdapter<String, ShoppingCenterGridAdapter.ShoppingCenterPropertyViewHolder>(
    DiffCallback
) {
    class ShoppingCenterPropertyViewHolder(private var binding: ShoppingcenterBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(avatarpart: String){
          //  binding.property = avatarpart
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingCenterPropertyViewHolder {
        return ShoppingCenterPropertyViewHolder(ShoppingcenterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: ShoppingCenterPropertyViewHolder,
        position: Int
    ) {
        val shoppingCenter = getItem(position)
        holder.bind(shoppingCenter)
    }
}


