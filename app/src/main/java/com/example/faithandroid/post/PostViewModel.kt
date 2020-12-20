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
import com.example.faithandroid.network.FaithApiService
import com.example.faithandroid.network.FaithProperty
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.*
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await


class PostViewModel(placeType: PlaceType,private val postRepository: PostRepository): ViewModel() {

    private var _postList : LiveData<Resource<List<Post>>> = postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)
    val postList: LiveData<Resource<List<Post>>>
        get() = _postList

    private var _filteredPostList : MutableLiveData<List<Post>> =  MutableLiveData()
    val filteredPostList: LiveData<List<Post>>
        get() = _filteredPostList


    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    private var _status = MutableLiveData<String>()
    var status: LiveData<String>
        get() = _status
        set(text) {
            _status.value = text.value
        }

    fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {
        viewModelScope.launch {
            val stringCall: Call<List<Post>> =
                postRepository.getFilteredFromPlace(placeType.ordinal, postType.ordinal)

            stringCall.enqueue(object : Callback<List<Post>> {

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                        if (response.body()!!.isEmpty()) {
                            _status.value = "Sorry er is niets om weer te geven"
                            _filteredPostList.value = response.body()
                        } else {
                            _filteredPostList.value = response.body()
                        }
                    } else {
                        _status.value = "Er kon geen verbinding gemaakt worden"
                    }
                }

                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    _status.value = "Er liep iets mis"
                }
        })
        }
    }

    fun addPostByEmail(post: Post, placeType: PlaceType): Boolean {
        var bool: Boolean = true
        viewModelScope.launch {
            val stringCall: Call<Void> =
                postRepository.addPostByEmail(post, placeType.ordinal)

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
                    _status.value = "Er liep iets mis bij het toevoegen."
                }
            })
        }
        return bool
    }

    fun addExistingPostToPlace(id: Int, placeType: PlaceType) {

        postRepository.addExistingPostToPlace(id, placeType.ordinal)

    }

    fun deletePostByEmail(id: Int, placeType: PlaceType) {
                postRepository.deletePostByEmail(placeType.ordinal, id)
    }

    fun requestConsultation() {
        viewModelScope.launch {
            try {
                postRepository.requestConsultation()
                _requestConsultationStatus.value = "gelukt!"

            } catch (e: Exception) {
                _requestConsultationStatus.value = "niet gelukt!"
            }
        }
    }


    fun pemanentlyDeletePost(postId: Int) {
            postRepository.permanentlyDeletePost(postId) //ERRORHANDELING MET RESPONSE
    }
}

