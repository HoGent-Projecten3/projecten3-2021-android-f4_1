package com.example.faithandroid.shoppingCenter

import android.util.Log
import android.widget.Switch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.Step
import com.example.faithandroid.network.FaithApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ShoppingCenterViewModel : ViewModel() {

     private val _status = MutableLiveData<String>()
     val status: LiveData<String>
          get() = _status

    val data = mutableListOf<String>("Hair_Standaard","Skin_Standaard","Upperbody_Standaard","Eye_Standaard")

    val Hair = mutableListOf<String>("Hair_Standaard","Hair_Standaard2","Upperbody_Standaard","Eye_Standaard")
    val Skin = mutableListOf<String>("Skin_Standaard2","Skin_Standaard","Upperbody_Standaard","Eye_Standaard")
    val UpperBody = mutableListOf<String>("Body_Standaard2","Skin_Standaard","Upperbody_Standaard","Eye_Standaard")
    val Eye = mutableListOf<String>("Eye_Standaard2","Skin_Standaard","Upperbody_Standaard","Eye_Standaard")


private val _properties = MutableLiveData<List<String>>()

    val properties: MutableLiveData<List<String>>
        get() = _properties


     private var viewModelJob = Job()
     private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

     init {

     }

     public fun getPosts() {
          coroutineScope.launch {

               try {
                    if(data.size > 0){
                         _properties.value = data
                    }
               } catch (e: Exception){
                    _status.value = "Failure: ${e.message}"
               }
          }
     }

    public fun getHair() {
        coroutineScope.launch {

            try {
                if(Hair.size > 0){
                    _properties.value = Hair
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    public fun getEye() {
        coroutineScope.launch {

            try {
                if(Eye.size > 0){
                    _properties.value = Eye
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    public fun getSkin() {
        coroutineScope.launch {

            try {
                if(Skin.size > 0){
                    _properties.value = Skin
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    public fun getUpperBody() {
        coroutineScope.launch {

            try {
                if(UpperBody.size > 0){
                    _properties.value = UpperBody
                }
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }



}
