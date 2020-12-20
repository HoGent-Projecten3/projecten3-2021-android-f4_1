package com.example.faithandroid.post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * This is the viewModel for all posts
 *
 * @property placeType is the place where the post needs to be added
 */
class PostViewModel(private var placeType: PlaceType): ViewModel() {

    /**
     * @param postList is the list of posts from a specific place, provided by the backend
     * @param status shows the status of the data in postList
     */
    private var _posts = MutableLiveData<List<Post>>()
    var postList: LiveData<List<Post>> = MutableLiveData<List<Post>>()
        get() = _posts

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init   {
        getPostsOfPlace(placeType)
    }

    /**
     * gets the posts of a given type for a specific place
     *
     * @param placeType is the place the posts need to come from
     * @param postType is the type the posts need to be
     */
    fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {

        viewModelScope.launch {

            val stringCall: Call<List<Post>> =
                FaithApi.retrofitService.getFilteredFromPlace(placeType.ordinal, postType.ordinal)

            stringCall.enqueue(object : Callback<List<Post>> {

                 override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                       if(response.body()!!.isEmpty())
                        {
                            _status.value = "Sorry er is niets om weer te geven"
                            _posts.value = response.body()
                        }else {
                            _posts.value = response.body()
                       }
                    }
                  else {
                            _status.value = "Er kon geen verbinding gemaakt worden"
                        }
                    }

                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    _status.value = "Er liep iets mis"
                    }

            })


        }

    }

    /**
     * gets the posts of a specific place, regardless of their posttype
     *
     * @param placeType is the place the posts need to come from
     */
    fun getPostsOfPlace(placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<List<Post>> =
                FaithApi.retrofitService.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)
            stringCall.enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                        _posts.value = response.body()
                    }
                }
                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    t?.localizedMessage?.let {

                    }
                }
            })
        }
    }

    /**
     * adds a post to a specific place
     *
     * @param post is the post that is to be added
     * @param placeType is the place the post is to be added to
     */
    fun addPostByEmail(post: Post, placeType: PlaceType): Boolean{
        var bool: Boolean = true
        viewModelScope.launch {
            val stringCall: Call<Void> =

                FaithApi.retrofitService.addPostByEmail(placeType.ordinal, post)

            stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        getPostsOfPlace(this@PostViewModel.placeType)
                        if (responseString != null) {

                        }
                    }
                }
                override fun onFailure(call: Call<Void>?, t: Throwable?) {
                    bool = false
                }
            })
        }
        return bool
        }

    /**
     * Adds a post that already exists within the app to another place
     *
     * @param id is the id of the post
     * @param placeType is the place the post needs to be added to
     */
    fun addExistingPostToPlace(id: Int, placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                FaithApi.retrofitService.addExistingPostToPlace(id, placeType.ordinal)
            stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        getPostsOfPlace(this@PostViewModel.placeType)
                        if (responseString != null) {

                        }
                    }
                }
                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }
            })
        }
    }

    /**
     * Deletes a post from a specific place
     *
     * @param id is the id of the post
     * @param placeType is the place the post will be deleted from
     */
    fun deletePostByEmail(id: Int,  placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                FaithApi.retrofitService.deletePostByEmail(placeType.ordinal,id)
            stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        getPostsOfPlace(this@PostViewModel.placeType)
                        if (responseString != null) {

                        }
                    }
                }
                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }
            })
        }
    }

    /**
     * Deletes a post from every place it exists and from the app altogether
     *
     * @param id is the id of the post to be deleted
     */
    fun pemanentlyDeletePost(postId: Int) {
        viewModelScope.launch {
            val stringCall: Call<Void> = FaithApi.retrofitService.permanentlyDeletePost(postId)
            stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        getPostsOfPlace(placeType)
                        if (responseString != null) {

                        }
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }
            })
        }
    }

}