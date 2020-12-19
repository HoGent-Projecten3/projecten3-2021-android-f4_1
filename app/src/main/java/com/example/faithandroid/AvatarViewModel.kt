package com.example.faithandroid

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.shoppingCenter.AvatarRepository
import com.example.faithandroid.skyscraper.GoalPostRepository
import com.example.faithandroid.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

class AvatarViewModel(private val avatarRepository: AvatarRepository) : ViewModel() {

     private val _status = MutableLiveData<String>()
     val status: LiveData<String>
          get() = _status

    val Hair = mutableListOf<Int>(
        Color.parseColor("#EEEE94"),
        Color.parseColor("#C46200"),
        Color.parseColor("#9C4E00"),
        Color.parseColor("#5E2F00"),
        Color.parseColor("#2E1700"),
        Color.parseColor("#EEEEEE"),
        Color.parseColor("#FF8000"),
        Color.parseColor("#FF0400"),
        Color.parseColor("#00B500"),
        Color.parseColor("#2D02EB"),
    )
    val Skin = mutableListOf<Int>(
        Color.parseColor("#F9B77D"),
        Color.parseColor("#B57134"),
        Color.parseColor("#8B5413"),
        Color.parseColor("#7B360F"),
        Color.parseColor("#58290D"),
        Color.parseColor("#EB5757"),
        Color.parseColor("#2F80ED"),
        Color.parseColor("#219653"),
        Color.parseColor("#F2C94C"),
        Color.parseColor("#9B51E0"),
        Color.parseColor("#EB5ACF")
        )
    val UpperBody = mutableListOf<Int>(
        Color.parseColor("#111111"),
        Color.parseColor("#EEEEEE"),
        Color.parseColor("#FF0400"),
        Color.parseColor("#00B500"),
        Color.parseColor("#2D02EB"),
        Color.parseColor("#F5E301"),
        Color.parseColor("#FF8000"),
        Color.parseColor("#7900EB"),
        Color.parseColor("#BD5F00"),
        Color.parseColor("#EB5ACF"),
        Color.parseColor("#777777"),
        Color.parseColor("#DB9200"),
    )
    val Eye = mutableListOf<Int>(
        Color.parseColor("#2D02EB"),
        Color.parseColor("#00B500"),
        Color.parseColor("#9C4E00"),
        Color.parseColor("#FF8000"),
        Color.parseColor("#111111"),
        Color.parseColor("#777777"),
        Color.parseColor("#FF0400"),

        )

    var currentAvatar : LiveData<Resource<Avatar>> = avatarRepository.getAvatar()

    private val _hairProperties = MutableLiveData<List<Int>>()
    private val _eyeProperties = MutableLiveData<List<Int>>()
    private val _skinProperties = MutableLiveData<List<Int>>()
    private val _bodyProperties = MutableLiveData<List<Int>>()

    //val currentAvatar: MutableLiveData<Avatar>
      //  get() = _currentAvatar

    val hairProperties: MutableLiveData<List<Int>>
        get() = _hairProperties
    val eyeProperties: MutableLiveData<List<Int>>
        get() = _eyeProperties
    val skinProperties: MutableLiveData<List<Int>>
        get() = _skinProperties
    val bodyProperties: MutableLiveData<List<Int>>
        get() = _bodyProperties


     private var viewModelJob = Job()
     private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

     init {
         getProperties()
         getAvatar()
     }

      fun getProperties() {
          coroutineScope.launch {

               try {
                    if(Hair.size > 0){
                        _hairProperties.value = Hair
                    }
                   if(Eye.size > 0){
                       _eyeProperties.value = Eye
                   }
                   if(Skin.size > 0){
                       _skinProperties.value = Skin
                   }
                   if(UpperBody.size > 0){
                       _bodyProperties.value = UpperBody
                   }
               } catch (e: Exception){
                    _status.value = "Failure: ${e.message}"
               }
          }
     }

     private fun getAvatar(){


                try{
                    //var getAvatar = avatarRepository.getAvatar()
                    //var result = getAvatar.value?.data

                    //_currentAvatar.value = result
                    AppPreferences.currentPerson = currentAvatar.value?.data?.person
                    AppPreferences.currentHair = currentAvatar.value?.data?.hair
                    AppPreferences.currentEyes = currentAvatar.value?.data?.eyes
                    AppPreferences.currentSkin = currentAvatar.value?.data?.skin
                    AppPreferences.currentBody = currentAvatar.value?.data?.upperBody

                }
                catch (e: Exception)
                {
                    _status.value = "Kan geen verbinding maken met de server"
                }

    }

     fun postAvatar(character: Int, hair: Int, eyes: Int, skin: Int, body: Int){
        //coroutineScope.launch{
            try{
                val avatar: Avatar = Avatar(id = 0,person = character, hair = hair, eyes = eyes, skin = skin, upperBody = body)
                avatarRepository.postAvatar(avatar)
                //currentAvatar = avatar
                AppPreferences.currentPerson = character
                AppPreferences.currentHair = hair
                AppPreferences.currentEyes = eyes
                AppPreferences.currentSkin = skin
                AppPreferences.currentBody = body
                _status.value = "gelukt!"

            }
            catch (e: Exception)
            {
                _status.value = "niet gelukt!"
            }
        }
    //}



}
