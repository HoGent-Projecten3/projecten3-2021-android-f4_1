package com.example.faithandroid.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faithandroid.PlaceType
import com.example.faithandroid.PostType
import com.example.faithandroid.models.Post
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * This is the viewModel for all posts
 *
 * @param placeType is the place where the post needs to be added
 * @property postList is the list of posts from a specific place, provided by the backend
 * @property status shows the status of the data in postList
 */
class PostViewModel(placeType: PlaceType, private val postRepository: PostRepository) : ViewModel() {

    /**
     * gets the posts of a specific place, regardless of their posttype
     *
     * @param placeType is the place the posts need to come from
     */
    private var _postList: LiveData<Resource<List<Post>>> = postRepository.getPostsOfPlaceByAdolescentEmail(placeType.ordinal)
    val postList: LiveData<Resource<List<Post>>>
        get() = _postList

    private var _filteredPostList: MutableLiveData<List<Post>> = MutableLiveData()
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

        /**
         * gets the posts of a given type for a specific place
         *
         * @param placeType is the place the posts need to come from
         * @param postType is the type the posts need to be
         */
    fun getFilteredPostFromPlace(placeType: PlaceType, postType: PostType) {
        viewModelScope.launch {
            val stringCall: Call<List<Post>> =
                postRepository.getFilteredFromPlace(placeType.ordinal, postType.ordinal)

            stringCall.enqueue(
                object : Callback<List<Post>> {

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
}
            )
        }
    }

    /**
     * adds a post to a specific place
     *
     * @param post is the post that is to be added
     * @param placeType is the place the post is to be added to
     * @return whether the adding of the post was successful
     */
    fun addPostByEmail(post: Post, placeType: PlaceType): Boolean {
        var bool: Boolean = true
        viewModelScope.launch {
            val stringCall: Call<Void> =
                postRepository.addPostByEmail(post, placeType.ordinal)

            stringCall.enqueue(
                object : Callback<Void> {
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
}
            )
        }
        return bool
    }

    /**
     * Adds a post that already exists within the app to another place
     *
     * @param id is the id of the post
     * @param placeType is the place the post needs to be added to
     */
    fun addExistingPostToPlace(id: Int, placeType: PlaceType) {
        postRepository.addExistingPostToPlace(id, placeType.ordinal)
    }

    /**
     * Deletes a post from every place it exists and from the app altogether
     *
     * @param postId is the id of the post to be deleted
     */
    fun pemanentlyDeletePost(postId: Int) {
        postRepository.permanentlyDeletePost(postId)
    }

        /**
         * Deletes a post from a specific place
         *
         * @param id is the id of the post
         * @param placeType is the place the post will be deleted from
         */
    fun deletePostByEmail(id: Int, placeType: PlaceType) {
                postRepository.deletePostByEmail(placeType.ordinal, id)
    }

    /**
     * requests a consultation for the logged in adolescent
     */
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
}
