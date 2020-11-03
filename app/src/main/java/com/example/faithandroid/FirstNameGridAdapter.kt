package com.example.faithandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.GridViewItemBinding
import com.example.faithandroid.network.FaithProperty

class FirstNameGridAdapter : ListAdapter<FaithProperty, FirstNameGridAdapter.FaithPropertyViewHolder>(DiffCallback) {
    class FaithPropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(faithProperty: FaithProperty){
            binding.property = faithProperty
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<FaithProperty>(){
        override fun areItemsTheSame(oldItem: FaithProperty, newItem: FaithProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: FaithProperty, newItem: FaithProperty): Boolean {
            return oldItem.email == newItem.email
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstNameGridAdapter.FaithPropertyViewHolder {
        return FaithPropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: FirstNameGridAdapter.FaithPropertyViewHolder,
        position: Int
    ) {
        val faithProperty = getItem(position)
        holder.bind(faithProperty)
    }
}