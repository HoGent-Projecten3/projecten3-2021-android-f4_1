package com.example.faithandroid.musicRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Playlist
import com.example.faithandroid.models.Post


class MusicRoomViewModel : ViewModel() {

    private var _playlists = mutableListOf<Playlist>(Playlist("1234","sad playlist","very sad playlist","https://mosaic.scdn.co/300/ab67616d0000b2731070095e88dce90a090171b5ab67616d0000b27314c07768d4acc4282a66a61bab67616d0000b273b061cb1eff0ce9595cc234b0ab67616d0000b273de2b4e2ae722a9f09b2a91ac"))
    val playlists: MutableList<Playlist>
        get() = _playlists

}