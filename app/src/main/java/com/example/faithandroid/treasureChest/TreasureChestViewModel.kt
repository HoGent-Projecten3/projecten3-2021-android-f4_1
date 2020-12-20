package com.example.faithandroid.treasureChest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TreasureChestViewModel : ViewModel() {

    // Error status
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    // Lijst van posts
    /*var mockData = mutableListOf<Post>(
        Post(7, "Image", "this is an image", "2012-03-19T07:22", PostType.Image.ordinal, "https://d16kd6gzalkogb.cloudfront.net/magazine_images/Salvador-Dali-The-Persistence-of-Memory-1931-c.jpg"),
        Post(8, "Video", "This is a video", "2012-03-19T07:22", PostType.Video.ordinal, "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        Post(9, "Audio", "This is audio", "2012-03-19T07:22", PostType.Audio.ordinal)

    )*/

    private val _postList = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _postList

    // GEEN IDEE
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init
    {
        getPostsOfTreasureChest()
    }

    // OPHALEN VAN DE LIJST
    fun getPostsOfTreasureChest() {
        coroutineScope.launch {
            /*try{
                var getPostList = FaithApi.retrofitService.getPostsOfPlaceByAdolescentEmail(PlaceType.Schatkist.ordinal)
                var result = getPostList.await()
                if(result.size > 0){

                    _postList.value = result
                }
                else
                {
                    _status.value = "De lijst is leeg"
                }
            }
            catch (e: Exception)
            {
                _status.value = "Kan geen verbinding maken met de server"
            }*/
        }
    }
}
