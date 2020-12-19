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

    //lateinit var postList: LiveData<Resource<List<Post>>>

    private var _postList = MutableLiveData<List<Post>>()
    var postList: LiveData<List<Post>> = MutableLiveData<List<Post>>()
        get() = _postList


    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    private var _status = MutableLiveData<String>()
    var status: LiveData<String>
        get() = _status
        set(text) { _status.value = text.value }

//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init   {
        getPostsOfPlace(placeType)
    }

     /*fun getPostsOfPlace(placeType: PlaceType)    {
        var test = postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)
        _postList = test as MutableLiveData<Resource<List<Post>>>
        }*/

      fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {
          viewModelScope.launch {

              val stringCall: Call<List<Post>> =
                  postRepository.getFilteredFromPlace(placeType.ordinal, postType.ordinal)

              stringCall.enqueue(object : Callback<List<Post>> {

                  override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                      if (response.isSuccessful()) {
                          if(response.body()!!.isEmpty())
                          {
                              _status.value = "Sorry er is niets om weer te geven"
                              _postList.value = response.body()
                          }else {
                              _postList.value = response.body()
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

    fun getPostsOfPlace(placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: Call<List<Post>> =
                postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)
            stringCall.enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                        _postList.value = response.body()
                    }
                }
                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    t?.localizedMessage?.let {

                    }
                    _status.value = "Er kon geen posts worden opgehaald."
                }
            })
        }
    }

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
                    _status.value = "Er liep iets mis bij het toevoegen."
                }
            })
        }
        return bool
        }

    fun addExistingPostToPlace(id: Int, placeType: PlaceType)    {

        viewModelScope.launch {
            Log.d("testVideo", id.toString() + placeType.name)
            val stringCall: Call<Void> =
                postRepository.addExistingPostToPlace(id, placeType.ordinal)
            stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        if (responseString != null) {
                        }
                        _status.value = "Post toegevoegd!"
                    }
                }
                override fun onFailure(call: Call<Void>?, t: Throwable?) {
                    _status.value = "Er liep iets mis bij het toevoegen.";
                }
            })
        }
        Log.d("testVideo", "Heeft methode doorlopen")
    }

    fun deletePostByEmail(id: Int,  placeType: PlaceType)    {
        viewModelScope.launch {
            val stringCall: LiveData<Resource<Void>> =
                postRepository.deletePostByEmail(placeType.ordinal,id)
            /*stringCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful()) {
                        val responseString: String? = response.code().toString()
                        if (responseString != null) {

                        }
                    }
                }
                override fun onFailure(call: Call<Void>?, t: Throwable?) {
                    _status.value = "Er liep iets mis bij het verwijderen."
                }
            })*/
        }
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
                    _status.value = "Er liep iets mis bij het verwijderen."
                }
            })
        }
}

