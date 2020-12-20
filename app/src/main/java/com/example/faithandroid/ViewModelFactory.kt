package com.example.faithandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel

/**
 *  class that keeps track of the place you've just been
 *
 *  @param param is the placeType where you have just been
 */
class ViewModelFactory(
    private var param: PlaceType,

    private var repo: PostRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(param, repo) as T
    }
}
