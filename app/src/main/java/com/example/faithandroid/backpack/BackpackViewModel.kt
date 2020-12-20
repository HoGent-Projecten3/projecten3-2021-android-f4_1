package com.example.faithandroid.backpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.PlaceType
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

/**
 * This is a viewModel that gets and keeps a list of all posts in backpack
 */
class BackpackViewModel : ViewModel() {
    //Error status

    /**
     * @property status shows the status of the data in the postList
     */
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    //Lijst van posts
    var mockData = mutableListOf<Post>(
        /*Post(0, "Op maandag zag ik een hond", "Ik was gaan wandelen met mijn mama en zag de schattigste hond. Het was een lieve hond en ik mocht hem aaien, wat ik echt fantastisch vond. Ik heb gevraagd of ik er misschien eens mee mocht gaan wandelen. De meneer zei dat dat zeker mocht", "2012-03-19T03:22"),
        Post(1, "Stomme school", "IK HAAT SCHOOL, IK SNAP NIET DAT IEMAND OOIT NAAR SCHOOL GAAT LAAT MIJ GEWOON SLAPEN", "2012-03-19T04:22"),
        Post(3, "Ik wil zo graag op reis gaan", "Maakt niet eens uit naar waar. Ik ben het beu om constant thuis te zitten zonder sociaal contact. Ik wil op roadtrip met mijn vrienden. Ik wil bergwandelingen maken en zwemmen in de zee. Ik wil een pintje drinken rond een kampvuur", "2012-03-19T05:22"),
        Post(4, "Ik voel mij echt slecht", "", "2012-03-19T07:22"),
        Post(5, "Opa heeft de taart laten aanbranden", "Ik weet niet zo goed wat ik moet voelen. Ik had echt wel zin in taart, maar ik weet ook dat hij er niets aan kan doen. Ik hoop gewoon dat ik snel weer wat taart ga kunnen eten. Opa is echt een warhoofd de laatste tijd. Gelukkig zijn zijn pannenkoeken nog topnotch", "2012-03-19T08:22"),
        Post(6, "noooo you cant just convert this meme to text", "description go brrrrrr", "2012-03-19T09:22"),
        Post(7, "Image", "this is an image", "2012-03-19T07:22", PostType.Image.ordinal, "https://d16kd6gzalkogb.cloudfront.net/magazine_images/Salvador-Dali-The-Persistence-of-Memory-1931-c.jpg"),
        Post(8, "Video", "This is a video", "2012-03-19T07:22", PostType.Video.ordinal, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        Post(9, "Audio", "This is audio", "2012-03-19T07:22", PostType.Audio.ordinal)*/
    )

    /**
     * @property postList is a list of the posts in backpack
     */
    private val _postList = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _postList


    //GEEN IDEE
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init
    {
        getPostsOfBackpack()
    }


    /**
     * This method gets the posts in backpack from the backend and puts them in the postList variable
     */
    fun getPostsOfBackpack()
    {
        coroutineScope.launch{
            try{
                var getPostList = FaithApi.retrofitService.getPostsOfPlaceByAdolescentEmail(PlaceType.Rugzak.ordinal)
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
            }
        }
    }
}