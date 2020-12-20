package com.example.faithandroid.bulletinboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class BulletinBoardViewModel : ViewModel() {

    // ERROR STATUS
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _requestConsultationStatus = MutableLiveData<String>("Er liep iets mis")
    val requestConsultationStatus: LiveData<String>
        get() = _requestConsultationStatus

    // LIJST VAN POSTS
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

    // GEEN IDEE
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
}
