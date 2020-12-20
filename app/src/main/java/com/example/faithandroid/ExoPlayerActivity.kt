package com.example.faithandroid

import android.content.ContentUris
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.util.Log
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

//import androidx.databinding.DataBindingUtil

/**
 * the activity for when the exoplayer is started when watching a video or listening to audio
 *
 * @property playerView is the view of the exoplayer
 * @property player is the exoplayer itself
 * @property postUri is the uri where the post needs to come from
 */
class ExoPlayerActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private var player: SimpleExoPlayer? = null
    private var postUri: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exoplayer)

        initializeViews()
        postUri = getIntent().getExtras()!!.getString("postUri").toString()
    }

    /**
     * initializes the playerView
     */
    fun initializeViews(){
        playerView = findViewById(R.id.playerView)
    }

    /**
     * initializes the player and adds it to the view
     */
    fun initializePlayer(){
        player = SimpleExoPlayer.Builder(this).build()
        playerView.setPlayer(player)

        //var videoUri: Uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoId)
        var mediaSource: MediaSource = buildMediaSource(Uri.parse(postUri))
        player?.prepare(mediaSource)
        player?.setPlayWhenReady(true)
    }

    /**
     * gets the source of the media
     *
     * @param uri is the uri the post comes from
     * @return the mediasource
     */
    private fun buildMediaSource(uri: Uri): MediaSource{
        var dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(this, getString(R.string.app_name))
        return ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }

    /**
     * stops the player
     */
    fun releasePlayer(){
        if (player != null){
            player?.release()
            player = null
        }
    }

    override fun onStart(){
        super.onStart()
        if(Util.SDK_INT>24){
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT < 24 || player == null){
            initializePlayer()
        }
    }

    override fun onPause(){
        if(Util.SDK_INT<24){
            releasePlayer();
        }
        super.onPause()
    }

    override fun onStop(){
        if(Util.SDK_INT<24){
            releasePlayer()
        }
        super.onStop()
    }
}