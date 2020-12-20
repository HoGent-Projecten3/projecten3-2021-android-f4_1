package com.example.faithandroid.billboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.BillboardGoalCustomClick
import com.example.faithandroid.databinding.BillboardBinding
import com.example.faithandroid.databinding.BillboardGoalBinding
import com.example.faithandroid.login.uilogin.LoginActivity
import com.example.faithandroid.login.uilogin.LoginResult
import com.example.faithandroid.models.Adolescent
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import com.example.faithandroid.post.audio.AddAudioFragmentArgs
import com.example.faithandroid.skyscraper.GoalDetailsFragmentArgs
import com.example.faithandroid.skyscraper.SkyscraperViewModel
import org.koin.android.ext.android.inject

class BillboardGridAdapter (private var listener: BillboardGoalCustomClick):  ListAdapter<GoalPost, BillboardGridAdapter.BillboardPropertyViewHolder>(
    DiffCallback
) {
    class BillboardPropertyViewHolder(private var binding: BillboardGoalBinding, private var listener: BillboardGoalCustomClick):
        RecyclerView.ViewHolder(binding.root){



        fun bind(goalPost: GoalPost){
            binding.property = goalPost
            binding.executePendingBindings()
            binding.goalUser = goalPost.firstname + " "+goalPost.name;
            binding.user = AppPreferences.firstname + " "+ AppPreferences.name ;

            binding.sharedGoalDeleteButton.setOnClickListener{
               listener.onClick(goalPost.id)
            }
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
        return BillboardPropertyViewHolder(BillboardGoalBinding.inflate(LayoutInflater.from(parent.context)), listener)
    }

    override fun onBindViewHolder(
        holder: BillboardPropertyViewHolder,
        position: Int
    ) {
        val billboard = getItem(position)
        holder.bind(billboard)
    }
}
