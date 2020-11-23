package com.example.faithandroid

import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.faithandroid.databinding.ListdataPostBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.example.faithandroid.network.FaithApi
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listdata_post.view.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle


class PostAdapter(private var listener: CustomLongClick) : ListAdapter<Post, PostAdapter.TreasureChestPostViewHolder>(
    DiffCallback
) {


    class TreasureChestPostViewHolder(private var binding: ListdataPostBinding, private var listener: CustomLongClick, private var parent: ViewGroup):
        RecyclerView.ViewHolder(binding.root){

        fun bind(post: Post){

            binding.post = post
            //inding.TreasurechestVideo.setVideoURI(Uri.parse(post.uri))
            if (post.postType == PostType.Image.ordinal){
                Picasso.get().load(post.uri).into(binding.TreasurechestImage)
                binding.TreasurechestImage.scaleType = ImageView.ScaleType.CENTER_CROP
            }

            val dialogClickListener = DialogInterface.OnClickListener{ _, which ->
                when(which){
                    DialogInterface.BUTTON_POSITIVE -> FaithApi.retrofitService.deletePostByEmail(post.id, "dora.theexplorer1999@gmail.com", PlaceType.Schatkist.ordinal)
                }
            }

            binding.DeletePostButton.setOnClickListener{
                view: View ->
                MaterialAlertDialogBuilder(view.getContext())
                    .setMessage("Ben je zeker dat je deze post wil verwijderen?")
                    .setPositiveButton("Ja", dialogClickListener)
                    .setNegativeButton("Nee", dialogClickListener)
                    .show()
            }


            binding.date = LocalDate.parse(post.date, DateTimeFormatter.ISO_LOCAL_DATE_TIME).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

            var card = binding.card

            card.setOnLongClickListener {
                listener.onClick(post)
                parent.children.forEach { view: View ->
                    view.card.setChecked(false)
                }
                card.setChecked(!card.isChecked)
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
    ): TreasureChestPostViewHolder {


        return TreasureChestPostViewHolder(
            ListdataPostBinding.inflate(LayoutInflater.from(parent.context)),
            listener, parent
        )
    }

    override fun onBindViewHolder(
        holder: TreasureChestPostViewHolder,
        position: Int
    ) {
        val post = getItem(position)
        holder.bind(post)

    }
}