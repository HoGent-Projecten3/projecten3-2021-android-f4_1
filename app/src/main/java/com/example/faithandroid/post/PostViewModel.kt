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
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(private var placeType: PlaceType): ViewModel() {

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

    fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {

        /*viewModelScope.launch {

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


        }*/

    }

    fun getPostsOfPlace(placeType: PlaceType)    {
       /* viewModelScope.launch {
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
        }*/
    }

    /*fun addPostByEmail(post: Post, placeType: PlaceType): Boolean{
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
    }*/

}