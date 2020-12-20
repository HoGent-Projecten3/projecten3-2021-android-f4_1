package com.example.faithandroid.billboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.BillboardBinding
import com.example.faithandroid.databinding.BillboardGoalBinding
import com.example.faithandroid.models.GoalPost
/**
 * This is the adapter for the recyclerview in billboard
 */
class BillboardGridAdapter : ListAdapter<GoalPost, BillboardGridAdapter.BillboardPropertyViewHolder>(
    DiffCallback
) {
    /**
     * This is a viewHolder for the BillboardGridAdapter
     *
     * @property binding is to bind a post.xml file
     */
    class BillboardPropertyViewHolder(private var binding: BillboardGoalBinding):
        RecyclerView.ViewHolder(binding.root){
        /**
         * binds the post to the Recyclerview in billboard
         */
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
        return BillboardPropertyViewHolder(BillboardGoalBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: BillboardPropertyViewHolder,
        position: Int
    ) {
        val billboard = getItem(position)
        holder.bind(billboard)
    }
}
