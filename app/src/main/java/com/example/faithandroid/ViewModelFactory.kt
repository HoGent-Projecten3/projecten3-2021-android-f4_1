package com.example.faithandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.post.PostViewModel


public class ViewModelFactory(//private lateinit var application: Application
    private var param: PlaceType
) :  ViewModelProvider.Factory {

    public fun ViewModelFactory( param: PlaceType) {
        //this.application = application;

    }



    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        return PostViewModel(param) as T
    }
}
