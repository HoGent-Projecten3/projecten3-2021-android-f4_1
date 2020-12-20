package com.example.faithandroid.bulletinboard

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.faithandroid.PlaceType
import com.example.faithandroid.R
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
/**
 * This is the viewModel for the bulletinboard
 */
class BulletinBoardViewModel : ViewModel() {

    //ERROR STATUS
    /**
     * @param status shows the status of the data in the postlist
     * @param requestConsultationStatus keeps track of whether the the request of a consultation was successful
     * @param postLiist is the list of posts in the bulletinboard, provided by the backend
     */
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    //LIJST VAN POSTS
//    var mockData = mutableListOf<Post>(
//        Post(0, "Op maandag zag ik een hond", "Ik was gaan wandelen met mijn mama en zag de schattigste hond. Het was een lieve hond en ik mocht hem aaien, wat ik echt fantastisch vond. Ik heb gevraagd of ik er misschien eens mee mocht gaan wandelen. De meneer zei dat dat zeker mocht", "2012-03-19T03:22"),
//        Post(1, "Stomme school", "IK HAAT SCHOOL, IK SNAP NIET DAT IEMAND OOIT NAAR SCHOOL GAAT LAAT MIJ GEWOON SLAPEN", "2012-03-19T04:22"),
//        Post(3, "Ik wil zo graag op reis gaan", "Maakt niet eens uit naar waar. Ik ben het beu om constant thuis te zitten zonder sociaal contact. Ik wil op roadtrip met mijn vrienden. Ik wil bergwandelingen maken en zwemmen in de zee. Ik wil een pintje drinken rond een kampvuur", "2012-03-19T05:22"),
//        Post(4, "Ik voel mij echt slecht", "", "2012-03-19T07:22"),
//        Post(5, "Opa heeft de taart laten aanbranden", "Ik weet niet zo goed wat ik moet voelen. Ik had echt wel zin in taart, maar ik weet ook dat hij er niets aan kan doen. Ik hoop gewoon dat ik snel weer wat taart ga kunnen eten. Opa is echt een warhoofd de laatste tijd. Gelukkig zijn zijn pannenkoeken nog topnotch", "2012-03-19T08:22"),
//        Post(6, "noooo you cant just convert this meme to text", "description go brrrrrr", "2012-03-19T09:22")
//    )
    private val _postList = MutableLiveData<List<Post>>()
    val postList: LiveData<List<Post>>
        get() = _postList


    //GEEN IDEE
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init
    {
        getPostsOfBulletinBoard()
    }


    //OPHALEN VAN DE LIJST
    /**
     * gets the list of posts in bulletinboard from the backend and puts them into the postList variable
     */
    fun getPostsOfBulletinBoard()
    {
        coroutineScope.launch{
           try{
               var getPostList = FaithApi.retrofitService.getPostsOfPlaceByAdolescentEmail(PlaceType.Prikbord.ordinal)
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


    //NIEUWE POST TOEVOEGEN
    fun addNewPostToBulletinBoard(post: Post)
    {

    }

    /**
     * requests a consultation for the logged in adolescent
     */
    fun requestConsultation()
    {
        coroutineScope.launch{
            try{
                FaithApi.retrofitService.requestConsultation().await()
                _requestConsultationStatus.value = "gelukt!"

            }
            catch (e: Exception)
            {
                _requestConsultationStatus.value = "niet gelukt!"
            }
        }

    }

    /**
     * deletes all posts in the bulletinboard
     */
    fun deleteAllBulletinPosts(){
        coroutineScope.launch{
            var getPostList = FaithApi.retrofitService.getPostsOfPlaceByAdolescentEmail(0);
            var result = getPostList.await()

                for (post in result) {
                    try{
                        val stringCall: Call<Void> =
                            FaithApi.retrofitService.deletePostByEmail(0, post.id)
                        stringCall.enqueue(object : Callback<Void> {

                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                if (response.isSuccessful()) {
                                    val responseString: String? = response.code().toString()
                                    if (responseString != null) {

                                    }
                                }
                            }
                            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                                throw Exception("Er liep iets mis tijdens het verwijderen")
                            }
                        })
                    }catch(e:Exception){
                        throw Exception("Er liep iets mis tijdens het verwijderen");
                    }
                }
        }
    }

}