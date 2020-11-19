package com.example.faithandroid.skyscraper

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.skyscraper.GoalDetailsFragmentArgs
import com.example.faithandroid.R
import com.example.faithandroid.databinding.SkyscraperGoaldetailsBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*

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

        binding.btnBehaald.setOnClickListener { view: View ->
            viewModel.goalBehaald(args.goal.id)
        }

        binding.btnDelen.setOnClickListener { view: View ->
            viewModel.shareGoal(args.goal.id)
        }

        binding.btnVerwijder.setOnClickListener { view: View ->
            viewModel.deleteGoal(args.goal.id)
        }

        viewModel.shareStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.shareStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.shareGoal(args.goal.id)
                }.show()
            }
        })

        viewModel.completedStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.completedStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.goalBehaald(args.goal.id)
                }.show()
            }
        })

        viewModel.removeStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.removeStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.deleteGoal(args.goal.id)
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