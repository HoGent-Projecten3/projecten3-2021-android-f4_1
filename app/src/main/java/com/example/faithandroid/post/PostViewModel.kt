package com.example.faithandroid.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import com.example.nativeapps.util.Resource
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

class PostViewModel(placeType: PlaceType,private val postRepository: PostRepository): ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _posts

    val repPosts: LiveData<Resource<List<Post>>> =
        postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)

    private val _filteredPosts = MutableLiveData<List<Post>>()
    val postListFiltered: LiveData<List<Post>>
        get() = _filteredPosts

    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


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

    fun requestConsultation()
    {
        viewModelScope.launch{
            try{
                FaithApi.retrofitService.requestConsultation("dora.theexplorer1999@gmail.com").await()
                _requestConsultationStatus.value = "gelukt!"

            }
            catch (e: Exception)
            {
                _requestConsultationStatus.value = "niet gelukt!"
            }
        }

    }



}