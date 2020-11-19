package com.example.faithandroid.treasureChest

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.VideoView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.faithandroid.ExoPlayer
import com.example.faithandroid.FullScreenImage
import com.example.faithandroid.databinding.TreasurechestPostBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class TreasureChestPostAdapter : ListAdapter<Post, TreasureChestPostAdapter.TreasureChestPostViewHolder>(
    DiffCallback
) {


    class TreasureChestPostViewHolder(private var binding: TreasurechestPostBinding):
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


        return TreasureChestPostViewHolder(TreasurechestPostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: TreasureChestPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)

        holder.itemView.setOnClickListener { view: View ->
            when (post.postType) {
                PostType.Image.ordinal -> {
                    var intent: Intent = Intent(view.getContext(), FullScreenImage::class.java).apply{
                        putExtra("imageUri", post.uri)
                    }
                    view.getContext().startActivity(intent)
                }

                PostType.Video.ordinal -> {
                    var intent: Intent = Intent(view.getContext(), ExoPlayer::class.java).apply{
                        putExtra("videoUri", post.uri)
                    }
                    view.getContext().startActivity(intent)
                }

                PostType.Text.ordinal -> {

                    MaterialAlertDialogBuilder(view.getContext())
                        .setTitle(post.title)
                        .setMessage(post.data)
                        .show()
                }

                PostType.Audio.ordinal -> {

                }
            }
        }

        fun setCardClickListeners(){

        }
    }
}