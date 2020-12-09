package com.example.faithandroid.shoppingCenter

import android.graphics.Color
import android.util.Log
import android.widget.Switch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.BodyType

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.Step
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

    private val _hairProperties = MutableLiveData<List<Int>>()
    private val _eyeProperties = MutableLiveData<List<Int>>()
    private val _skinProperties = MutableLiveData<List<Int>>()
    private val _bodyProperties = MutableLiveData<List<Int>>()

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

    public fun changeAvatarPart(bodyType: BodyType, color: Int){

    }



}
