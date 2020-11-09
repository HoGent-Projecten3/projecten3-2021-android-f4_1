package com.example.faithandroid.billboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.FragmentBilboardGoalBinding
import com.example.faithandroid.models.GoalPost

class BillboardGridAdapter : ListAdapter<GoalPost, BillboardGridAdapter.BillboardPropertyViewHolder>(
    DiffCallback
) {
    class BillboardPropertyViewHolder(private var binding: FragmentBilboardGoalBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(goalPost: GoalPost){
            binding.property = goalPost
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<GoalPost>(){
        override fun areItemsTheSame(oldItem: GoalPost, newItem: GoalPost): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GoalPost, newItem: GoalPost): Boolean {
            return oldItem.id == newItem.id
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BillboardPropertyViewHolder {
        return BillboardPropertyViewHolder(FragmentBilboardGoalBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: BillboardPropertyViewHolder,
        position: Int
    ) {
        val billboard = getItem(position)
        holder.bind(billboard)
    }
}
