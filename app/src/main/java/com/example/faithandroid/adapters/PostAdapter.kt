package com.example.faithandroid.adapters

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.faithandroid.*
import com.example.faithandroid.databinding.PostBinding

import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class PostAdapter(private var listener: CustomClick) : ListAdapter<Post, PostAdapter.PostViewHolder>(
    DiffCallback
) {


    class PostViewHolder(private var binding: PostBinding, private var listener: CustomClick, private var parent: ViewGroup):
        RecyclerView.ViewHolder(binding.root){

        fun bind(post: Post){

            if(binding.TreasurechestImage.height>200){
                binding.TreasurechestImage.height.rangeTo(200)
            }

            binding.post = post
            if (post.postType == PostType.Image.ordinal){
                Picasso.get().load(post.uri).into(binding.TreasurechestImage)
            }else if(post.postType == PostType.Audio.ordinal){
                binding.TreasurechestImage.setImageResource(R.drawable.sound)
            }else{
                binding.TreasurechestImage.visibility = View.INVISIBLE
            }
            Glide.with(itemView.context).load(post.uri).into(binding.TreasurechestImage)

            /*val dialogClickListener = DialogInterface.OnClickListener{ _, which ->
                when(which){
                    DialogInterface.BUTTON_POSITIVE -> FaithApi.retrofitService.deletePostByEmail(PlaceType.Schatkist.ordinal, post.id)
                }
            }*/

            binding.DeletePostButton.setOnClickListener{
                view: View ->

                MaterialAlertDialogBuilder(view.getContext())
                    .setMessage("Ben je zeker dat je deze post wil verwijderen?")
                    .setPositiveButton("Ja"){_, which ->

                        listener.onClick(post)
                    }
                    .setNegativeButton("Nee"){_, which ->
                    }.show()
            }


            binding.date = LocalDate.parse(post.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

            var card = binding.card


            //Glide.with(itemView.context).load(post.uri).into(binding.TreasurechestImage)
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
                    else -> {}
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
    ): PostViewHolder {


        return PostViewHolder(
            PostBinding.inflate(LayoutInflater.from(parent.context)),
            listener, parent
        )
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)

    }
}
