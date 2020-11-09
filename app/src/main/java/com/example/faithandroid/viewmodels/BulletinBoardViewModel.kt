package com.example.faithandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.TextPost
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BulletinBoardViewModel : ViewModel() {

    //ERROR STATUS
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    //LIJST VAN POSTS
    var mockData = mutableListOf<Post>(Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm") ,Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"), Post(0, "help haha", "lalalalalalalalalaallalalalala dit si ejafkdsfksdgkdsrkfsdgkskfdskfgaskfdsglasfldvdslfbmdsfofnsdojfobjdiofjdiovgjdsibjfdifjdiobsdf", "datummm"))
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
    fun getPostsOfBulletinBoard()
    {
        coroutineScope.launch{
           try{
               var getPostList = FaithApi.retrofitService.getPostsOfBulletinBoardByAdolescentEmail("dora.theexplorer1999@gmail.com")
               var result = getPostList.await()
               if(result.size > 0){

                   _postList.value = result
               }
               else
               {
                   _status.value = "de lijst is leeg"
               }
           }
           catch (e: Exception)
           {
               _status.value = e.localizedMessage
           }
        }
    }


    //NIEUWE POST TOEVOEGEN
    fun addNewPostToBulletinBoard(post: Post)
    {

    }

}