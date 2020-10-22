package com.example.faithandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faithandroid.models.TextPost

class BulletinBoardViewModel : ViewModel() {

    var test = mutableListOf<TextPost>(TextPost("help ik voel me niet goed", "Dit is een bericht over waarom ik me niet goed voel"),TextPost("nu voel ik me beter", "Ik voel me nu al veel beter joupieeee"))

    private var testLive = MutableLiveData<String>("reeeeeeee")

    val testLivePublic: LiveData<String>
    get() = testLive
}