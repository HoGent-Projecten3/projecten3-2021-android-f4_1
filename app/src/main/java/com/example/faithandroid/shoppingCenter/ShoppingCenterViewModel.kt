package com.example.faithandroid.shoppingCenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Post
import com.example.faithandroid.models.Step

class ShoppingCenterViewModel : ViewModel() {

     val _properties = mutableListOf<String>("Hair_Standaard","Skin_Standaard","Upperbody_Standaard","Eye_Standaard")


    /*val properties: MutableLiveData<String>
        get() = _properties*/
}