package com.example.faithandroid.adapters

import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.faithandroid.*
import com.example.faithandroid.databinding.FilteredPostBinding

import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class FilteredPostAdapter(private var listener: CustomClick) : ListAdapter<Post, FilteredPostAdapter.FilteredPostViewHolder>(
    DiffCallback
) {


    class FilteredPostViewHolder(private var binding: FilteredPostBinding, private var listener: CustomClick, private var parent: ViewGroup):
        RecyclerView.ViewHolder(binding.root){

        fun bind(post: Post){

            binding.post = post
            //inding.TreasurechestVideo.setVideoURI(Uri.parse(post.uri))
            if (post.postType == PostType.Image.ordinal){
                Picasso.get().load(post.uri).into(binding.TreasurechestImage)
                //binding.TreasurechestImage.scaleType = ImageView.ScaleType.CENTER_CROP
            }else if(post.postType == PostType.Audio.ordinal){
                binding.TreasurechestImage.visibility = GONE
            }
            else if(post.postType == PostType.Video.ordinal){
                Glide.with(itemView.context).load(post.uri).into(binding.TreasurechestImage)
            }else{
                binding.TreasurechestImage.visibility = INVISIBLE
            }

            /*val dialogClickListener = DialogInterface.OnClickListener{ _, which ->
                when(which){
                    DialogInterface.BUTTON_POSITIVE -> retrofitService.deletePostByEmail(PlaceType.Schatkist.ordinal, post.id )
                }
            }*/



            binding.date = LocalDate.parse(post.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

            var card = binding.filteredPostCard

            card.setOnLongClickListener {
                card.setChecked(!card.isChecked)
                listener.onClick(post)

                true
            }

            card.setOnClickListener { view: View ->
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
    ): FilteredPostViewHolder {


        return FilteredPostViewHolder(
            FilteredPostBinding.inflate(LayoutInflater.from(parent.context)),
            listener, parent
        )
    }

    override fun onBindViewHolder(
        holder: FilteredPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)

    }
}