package com.example.faithandroid.musicRoom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.CustomPlaylistClick
import com.example.faithandroid.billboard.BillboardGridAdapter
import com.example.faithandroid.databinding.BillboardGoalBinding
import com.example.faithandroid.databinding.MusicroomPlaylistPostBinding
import com.example.faithandroid.models.Playlist
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

/**
 * adapter for the recyclerview in music room
 */
class PlaylistAdapter(private var listener: CustomPlaylistClick, private var deleteListener: CustomPlaylistClick)  : ListAdapter<Playlist, PlaylistAdapter.PlaylistViewHolder>(
    DiffCallback
) {
    class PlaylistViewHolder(private var binding: MusicroomPlaylistPostBinding, private var listener: CustomPlaylistClick, private var deleteListener: CustomPlaylistClick):
        RecyclerView.ViewHolder(binding.root){
        fun bind(playlist: Playlist){
            binding.playlist = playlist
            if(playlist.url.isNotEmpty())
            {
                Picasso.get().load(playlist.url).into(binding.playListCover)
            }

            binding.deletePlayListButton.setOnClickListener {
                deleteListener.onClick(playlist)
            }

            binding.card.setOnClickListener {
                if(!listener.onClick(playlist))
                {
                    Snackbar.make(binding.root, "Spotify is niet geinstalleerd op dit toestel", Snackbar.LENGTH_SHORT).show()
                }
            }

            binding.executePendingBindings()
        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<Playlist>(){
        override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
            return oldItem.id == newItem.id
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaylistViewHolder {
        return PlaylistViewHolder(MusicroomPlaylistPostBinding.inflate(LayoutInflater.from(parent.context)), listener, deleteListener)
    }

    override fun onBindViewHolder(
        holder: PlaylistViewHolder,
        position: Int
    ) {
        val playlist = getItem(position)
        holder.bind(playlist)
    }
}
