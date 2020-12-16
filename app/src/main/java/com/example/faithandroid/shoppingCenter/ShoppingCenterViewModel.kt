package com.example.faithandroid.shoppingCenter

import android.graphics.Color
import android.util.Log
import android.widget.Switch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.BodyType
import com.example.faithandroid.PlaceType
import com.example.faithandroid.models.Avatar

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.Step
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

class ShoppingCenterViewModel : ViewModel() {

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

    private var _currentCharacter = MutableLiveData<Int>()
    private var _currentHair = MutableLiveData<Int>()
    private var _currentEyes = MutableLiveData<Int>()
    private var _currentSkin = MutableLiveData<Int>()
    private var _currentBody = MutableLiveData<Int>()

    private val _hairProperties = MutableLiveData<List<Int>>()
    private val _eyeProperties = MutableLiveData<List<Int>>()
    private val _skinProperties = MutableLiveData<List<Int>>()
    private val _bodyProperties = MutableLiveData<List<Int>>()

    val currentCharacter: MutableLiveData<Int>
        get() = _currentCharacter
    val currentHair: MutableLiveData<Int>
        get() = _currentHair
    val currentEyes: MutableLiveData<Int>
        get() = _currentEyes
    val currentSkin: MutableLiveData<Int>
        get() = _currentSkin
    val currentBody: MutableLiveData<Int>
        get() = _currentBody

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

     public fun getProperties() {
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

    public fun getAvatar(){

            coroutineScope.launch{
                try{
                    var getAvatar = FaithApi.retrofitService.getAvatar(
                        )
                    var result = getAvatar.await()
                    if(result != null){

                        _currentCharacter.value = result.person
                        _currentHair.value = result.hair
                        _currentEyes.value = result.eyes
                        _currentSkin.value = result.skin
                        _currentBody.value = result.upperBody

                    }
                    else
                    {
                        _status.value = "De avatar was niet compleet"
                    }
                }
                catch (e: Exception)
                {
                    _status.value = "Kan geen verbinding maken met de server"
                }
            }

    }

    public fun postAvatar(character: Int, hair: Int, eyes: Int, skin: Int, body: Int){
        coroutineScope.launch{
            try{
                val avatarInts = listOf(character, hair, eyes, skin, body)
                val avatar: Avatar = Avatar(person = character, hair = hair, eyes = eyes, skin = skin, upperBody = body)
                FaithApi.retrofitService.postAvatar(avatar).await()
                _status.value = "gelukt!"

            }
            catch (e: Exception)
            {
                _status.value = "niet gelukt!"
            }
        }
    }



}
