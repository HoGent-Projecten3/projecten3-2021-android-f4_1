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
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await


class PostViewModel(placeType: PlaceType,private val postRepository: PostRepository): ViewModel() {

    var postList: LiveData<Resource<List<Post>>> = postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)


    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /*init   {
        getPostsOfPlace(placeType)
    }*/

     fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {

        viewModelScope.launch {
            val stringCall =
                postRepository.getFilteredFromPlace(placeType.ordinal, postType.ordinal)
            postList = stringCall

            Log.d("repo", postList.value.toString())
            /*stringCall.observe(object : Callback<List<Post>> {

                 override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                       if(response.body()!!.isEmpty())
                        {
                            _status.value = "Sorry er is niets om weer te geven"
                            postList.value = response.body()
                        }else {
                           postList.value = response.body()
                       }
                    }
                  else {
                            _status.value = "Er kon geen verbinding gemaakt worden"
                        }
                    }

                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    _status.value = "Er liep iets mis"
                    }

            })*/


        }

    }

    /*fun getPostsOfPlace(placeType: PlaceType)    {
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
    }*/

    fun addPostByEmail(post: Post, placeType: PlaceType): Boolean{
        var bool: Boolean = true
        viewModelScope.launch {
            val stringCall: Call<Void> =

                postRepository.addPostByEmail(post,placeType.ordinal)

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

    fun addExistingPostToPlace(id: Int, placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                postRepository.addExistingPostToPlace(id, placeType.ordinal)
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

    fun deletePostByEmail(id: Int,  placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<Void> =
                postRepository.deletePostByEmail(placeType.ordinal,id)
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

    fun requestConsultation() {
        viewModelScope.launch {
            try {
                postRepository.requestConsultation().await()
                _requestConsultationStatus.value = "gelukt!"

            } catch (e: Exception) {
                _requestConsultationStatus.value = "niet gelukt!"
            }
        }
    }


        fun pemanentlyDeletePost(postId: Int) {
            viewModelScope.launch {
                val stringCall: Call<Void> = postRepository.permanentlyDeletePost(postId)
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