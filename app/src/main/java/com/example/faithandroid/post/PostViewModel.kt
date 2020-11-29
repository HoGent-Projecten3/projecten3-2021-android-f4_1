package com.example.faithandroid.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(placeType: PlaceType): ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _posts

    private val _filteredPosts = MutableLiveData<List<Post>>()
    val postListFiltered: LiveData<List<Post>>
        get() = _filteredPosts

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init
    {
        getPostsOfPlace(placeType, "dora.theexplorer1999@gmail.com")

    }

    fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType, email: String) {

        viewModelScope.launch {

            val stringCall: Call<List<Post>> =
                FaithApi.retrofitService.getFilteredFromPlace(placeType.ordinal, postType.ordinal, email)

            stringCall.enqueue(object : Callback<List<Post>> {

                 override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {

                        _filteredPosts.value = response.body()


                    }
                     else
                    {
                        _status.value = "Er kon geen verbinding gemaakt worden"
                    }
                    }

                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    _status.value = "Er liep iets mis"
                    }




            })
        }
    }

    fun getPostsOfPlace(placeType: PlaceType, email: String)
    {
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

    fun addPostByEmail(post: Post, placeType: PlaceType, email: String): Boolean{
        var bool: Boolean = true

        viewModelScope.launch {
            val stringCall: Call<Void> =
                FaithApi.retrofitService.addPostByEmail(post,email, placeType.ordinal)
            stringCall.enqueue(object : Callback<Void> {

                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()

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

    fun addExistingPostToPlace(id: Int, placeType: PlaceType)
    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                FaithApi.retrofitService.addExistingPostToPlace(id, placeType.ordinal)
            stringCall.enqueue(object : Callback<Void> {

                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()

                        if (responseString != null) {


                        }
                    }

                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {

                }
            })
        }
    }

    fun deletePostByEmail(id: Int, email: String, placeType: PlaceType)
    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                FaithApi.retrofitService.deletePostByEmail(id, email, placeType.ordinal)
            stringCall.enqueue(object : Callback<Void> {

                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()

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