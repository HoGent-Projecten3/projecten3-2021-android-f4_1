package com.example.faithandroid

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.faithandroid.databinding.ListdataPostBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class PostAdapter( private var listener: CustomLongClick) : ListAdapter<Post, PostAdapter.TreasureChestPostViewHolder>(
    DiffCallback
) {


    class TreasureChestPostViewHolder(private var binding: ListdataPostBinding, private var listener: CustomLongClick):
        RecyclerView.ViewHolder(binding.root){


        fun bind(post: Post){

            binding.post = post
            //inding.TreasurechestVideo.setVideoURI(Uri.parse(post.uri))
            if (post.postType == PostType.Image.ordinal){
                Picasso.get().load(post.uri).into(binding.TreasurechestImage)
            }
            binding.date = LocalDate.parse(post.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

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
    ): TreasureChestPostViewHolder {


        return TreasureChestPostViewHolder(
            ListdataPostBinding.inflate(LayoutInflater.from(parent.context)),
            listener
        )
    }

    override fun onBindViewHolder(
        holder: TreasureChestPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)

        holder.itemView.setOnLongClickListener{
            listener.onClick(post)
            true
        }

        holder.itemView.setOnClickListener { view: View ->
            when (post.postType) {
                PostType.Image.ordinal -> {
                    var intent: Intent = Intent(view.getContext(), FullScreenImageActivity::class.java).apply{
                        putExtra("imageUri", post.uri)
                    }
                    view.getContext().startActivity(intent)
                }

                PostType.Video.ordinal, PostType.Audio.ordinal -> {
                    var intent: Intent = Intent(view.getContext(), ExoPlayerActivity::class.java).apply{
                        putExtra("postUri", post.uri)
                    }
                    view.getContext().startActivity(intent)
                }

                PostType.Text.ordinal -> {

                    MaterialAlertDialogBuilder(view.getContext())
                        .setTitle(post.title)
                        .setMessage(post.data)
                        .show()
                }
            }
        }
    }
}