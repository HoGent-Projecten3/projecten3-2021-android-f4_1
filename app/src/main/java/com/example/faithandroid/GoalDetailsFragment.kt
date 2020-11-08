package com.example.faithandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.databinding.FragmentGoaldetailsBinding
import com.example.faithandroid.databinding.FragmentMusicroomBinding
import com.example.faithandroid.viewmodels.GoalDetailsViewModel
import com.example.faithandroid.viewmodels.MusicRoomViewModel
import com.example.faithandroid.viewmodels.SkyscraperViewModel

class GoalDetailsFragment: DialogFragment() {
    private lateinit var viewModel: GoalDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val application = requireNotNull(activity).application

        viewModel = ViewModelProvider(this).get(GoalDetailsViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentGoaldetailsBinding>(
            inflater,
            R.layout.fragment_goaldetails,
            container,
            false
        );
        //binding.lifecycleOwner = this

        //val faithProperty = goalDetailsFragmentArgs.fromBundle(requireArguments()).title
        Log.d("yeeyee", "hewoo")

        return binding.root

    }
    /*
    * val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val marsProperty = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetailViewModelFactory(marsProperty, application)
        binding.viewModel = ViewModelProvider(
                this, viewModelFactory).get(DetailViewModel::class.java)
        return binding.root
        * */


}