package com.example.faithandroid.backpack

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.BackpackPostBinding
import com.example.faithandroid.databinding.TreasurechestPostBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

class BackpackPostAdapter : ListAdapter<Post, BackpackPostAdapter.BackpackPostViewHolder>(
    DiffCallback
) {
    class BackpackPostViewHolder(private var binding: BackpackPostBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(post: Post){
            binding.post = post
            //inding.TreasurechestVideo.setVideoURI(Uri.parse(post.uri))
            if (post.postType == PostType.Image){
                Picasso.get().load(post.uri).into(binding.BackpackImage)
            }
            if (post.postType == PostType.Video){

            }
            binding.date = LocalDate.parse(post.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

            binding.executePendingBindings()

            binding.backpackCard.setOnClickListener { view: View ->
                when (post.postType) {
                    PostType.Image -> {
                        /*var imageView: ImageView? = null
                        imageView?.setImageURI(Uri.parse(post.uri))
                        MaterialAlertDialogBuilder(binding.root.context)
                            .setView(binding.TreasurechestImage)
                            .show()*/
                    }

                    PostType.Video -> {

                    }

                    PostType.Text -> {
                        MaterialAlertDialogBuilder(binding.root.context)
                            .setTitle(post.title)
                            .setMessage(post.data)
                            .show()
                    }

                    PostType.Audio -> {

                    }
                }
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
    ): BackpackPostViewHolder {


        return BackpackPostViewHolder(BackpackPostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: BackpackPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)
    }
}