package com.example.faithandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class PostViewModel {

    private val _posts = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _posts
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getPostFromPlace(placeType: PlaceType, postType: PostType, email: String) {



        coroutineScope.launch {

            val stringCall: Call<List<Post>> =
                FaithApi.retrofitService.getFilteredFromPlace(placeType, postType, email)

            stringCall.enqueue(object : Callback<List<Post>> {

                 override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful()) {
                        _posts.value = response.body()
                        Log.d("azize", response.body()?.size.toString())


                    }
                    }

                override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                    t?.localizedMessage?.let {
                        Log.d("niet gelukt", it)
                    }

                }
            })
        }
    }

    fun addPostByEmail(post: Post, placeType: PlaceType, email: String){

        val stringCall: Call<Void> =
            FaithApi.retrofitService.addPostByEmail(post,placeType,email)
        stringCall.enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful()) {
                    val responseString: String? = response.code().toString()

                    if (responseString != null) {
                        Log.d("gelukt", responseString)

                    }
                }
            }

            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                t?.localizedMessage?.let { Log.d("errorr", it) }
                Log.d("errorr", "zonder error")
            }
        })
    }

}