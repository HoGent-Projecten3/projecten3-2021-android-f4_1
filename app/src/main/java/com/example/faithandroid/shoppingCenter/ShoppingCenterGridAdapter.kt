package com.example.faithandroid.shoppingCenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.AvatarCustomClick
import com.example.faithandroid.BodyType
import com.example.faithandroid.CustomClick
import com.example.faithandroid.R
import com.example.faithandroid.databinding.AvatarpartBinding
import com.example.faithandroid.databinding.ShoppingcenterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ShoppingCenterGridAdapter(private var bodyType: BodyType, private var listener: AvatarCustomClick): ListAdapter<Int, ShoppingCenterGridAdapter.ShoppingCenterPropertyViewHolder>(
    DiffCallback
) {
    class ShoppingCenterPropertyViewHolder(private var binding: AvatarpartBinding, private var bodyType: BodyType, private var listener: AvatarCustomClick):
        RecyclerView.ViewHolder(binding.root){
        fun bind(avatarpart: Int){
            binding.property = avatarpart
            binding.executePendingBindings()
            binding.cardView.setOnClickListener{
                    view: View ->
                /*MaterialAlertDialogBuilder(view.getContext())
                    .setMessage("Dit is " + bodyType.name + " met code " + binding.colourView.background)
                    .show()*/
                listener.onClick(avatarpart)
            }
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingCenterPropertyViewHolder {
        return ShoppingCenterPropertyViewHolder(AvatarpartBinding.inflate(LayoutInflater.from(parent.context)), bodyType, listener)
    }

    override fun onBindViewHolder(
        holder: ShoppingCenterPropertyViewHolder,
        position: Int
    ) {
        val shoppingCenter = getItem(position)
        holder.bind(shoppingCenter)
    }
}


