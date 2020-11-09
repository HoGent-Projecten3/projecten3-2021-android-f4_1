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
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.viewmodels.GoalDetailsViewModel
import com.example.faithandroid.viewmodels.MusicRoomViewModel
import com.example.faithandroid.viewmodels.SkyscraperViewModel

class GoalDetailsFragment: DialogFragment() {
    val args: GoalDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val application = requireNotNull(activity).application

        viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentGoaldetailsBinding>(
            inflater,
            R.layout.fragment_goaldetails,
            container,
            false
        );
        //binding.lifecycleOwner = this

        //val faithProperty = goalDetailsFragmentArgs.fromBundle(requireArguments()).title
        Log.d("yeeyee", "hewoo")


        binding.titelText.text = args.goal.title
        binding.beschrijvingText.text = args.goal.description
        binding.behaaldCheckbox.isChecked = args.goal.completed

        binding.behaaldCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.checkGoalBehaald(args.goal.completed, args.goal.id)
            binding.behaaldCheckbox.isClickable = false;
        }


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