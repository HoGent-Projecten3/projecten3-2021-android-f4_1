package com.example.faithandroid.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.faithandroid.R
import com.example.faithandroid.network.FaithProperty


//DetailViewModel(marsProperty: MarsProperty, app: Application) : AndroidViewModel(app)
class GoalDetailsViewModel: ViewModel(){

    private val _selectedProperty = MutableLiveData<FaithProperty>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<FaithProperty>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        //_selectedProperty.value = faithProperty
    }


    val displayPropertyType = Transformations.map(selectedProperty) {

    }

}