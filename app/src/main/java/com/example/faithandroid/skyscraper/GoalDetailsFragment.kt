package com.example.faithandroid.skyscraper

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.skyscraper.GoalDetailsFragmentArgs
import com.example.faithandroid.R
import com.example.faithandroid.databinding.SkyscraperGoaldetailsBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class GoalDetailsFragment: DialogFragment() {
    val args: GoalDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val application = requireNotNull(activity).application

        viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)

        val binding = DataBindingUtil.inflate<SkyscraperGoaldetailsBinding>(
            inflater,
            R.layout.skyscraper_goaldetails,
            container,
            false
        );
        //binding.lifecycleOwner = this

        //val faithProperty = goalDetailsFragmentArgs.fromBundle(requireArguments()).title


        binding.titelText.text = args.goal.title
        binding.beschrijvingText.text = args.goal.description

       // binding.goalShared = args.goal.shared
        binding.goalDetail = args.goal.completed

        var date = LocalDateTime.parse(args.goal.date)
        var date3 = date.dayOfMonth.toString() +" "+ date.month.toString()+ " "+ date.year.toString()
        binding.datumText.text = date3


        binding.btnBehaald.setOnClickListener { view: View ->
            viewModel.goalBehaald(args.goal.id)
        }

        binding.btnDelen.setOnClickListener { view: View ->
            viewModel.shareGoal(args.goal.id)
        }

        binding.btnVerwijder.setOnClickListener { view: View ->
            viewModel.deleteGoal(args.goal.id)
            view.findNavController().navigate(R.id.skyscraperFragment)
        }

        viewModel.shareStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {

                Snackbar.make(contextView, viewModel.shareStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                   "Goal gedeeld"
                )
                {

                }.show()
            }
        })

        viewModel.completedStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.completedStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    "Doel behaald"
                )
                {

                }.show()
            }
        })

        viewModel.removeStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Log.d("Deleted???", viewModel.removeStatus.value.toString())
                Snackbar.make(contextView, viewModel.removeStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    "Doel verwijderd"
                )
                {

                }.show()
            }
        })

        args.goal.steps.forEach{step ->
            val textView = TextView(context)
            textView.text = step.stepText
            binding.stepList.addView(textView)
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

