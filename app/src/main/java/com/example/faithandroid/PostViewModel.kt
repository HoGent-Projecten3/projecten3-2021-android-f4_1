package com.example.faithandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Post

class PostViewModel {

    private val _videos = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _videos

    fun getVideosFromPlace(placeType: PlaceType)
    {

    }

}