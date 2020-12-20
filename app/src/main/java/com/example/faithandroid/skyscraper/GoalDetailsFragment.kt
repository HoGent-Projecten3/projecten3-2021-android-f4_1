package com.example.faithandroid.skyscraper

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

/**
 * This is a fragment for the details of a goal
 */
class GoalDetailsFragment: DialogFragment() {

    /**
     * @param args ----------????------------
     * @param viewModel is the viewmodel for skyscraper
     */
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
        binding.goalShared = args.goal.shared
        binding.goalDetail = args.goal.completed

        var localdate = LocalDateTime.parse(args.goal.date)
        var date = localdate.dayOfMonth.toString() +" "+ localdate.month.toString()+ " "+ localdate.year.toString()
        binding.datumText.text = date

        binding.btnBehaald.setOnClickListener { view: View ->
            viewModel.goalBehaald(args.goal.id)
            view.findNavController().navigate(R.id.skyscraperFragment)
        }

        binding.btnDelen.setOnClickListener { view: View ->
            viewModel.shareGoal(args.goal.id)
           view.findNavController().navigate(R.id.billboardFragment)
        }

        binding.btnVerwijder.setOnClickListener { view: View ->
          if (args.goal.shared) {

                MaterialAlertDialogBuilder(view.getContext())
                    .setTitle("Goal verwijderen")
                    .setMessage("Deze goal is gedeeld. Ben je zeker dat je deze goal wilt verwijderen? ")
                    .setPositiveButton("Ja") { _, which ->
                        // unshare goal en then delete goal
                        viewModel.shareGoal(args.goal.id)
                        viewModel.deleteGoal(args.goal.id)
                        view.findNavController().navigate(R.id.skyscraperFragment)
                    }
                    .setNegativeButton("Nee") { _, which ->
                        // nothing has to happen here
                    }.show()
            }else if(args.goal.completed){
              Snackbar.make(view, "Deze goal is behaald, u kan deze dus niet verwijderen.", Snackbar.LENGTH_SHORT).setAction(
               "" )
              {
              }.show()
        }
          else {
                viewModel.deleteGoal(args.goal.id)
                view.findNavController().navigate(R.id.skyscraperFragment)
            }
        }

        viewModel.shareStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Toast.makeText(
                    context,
                    "Je doel is gedeeld",
                    Toast.LENGTH_LONG
                ).show()
             }
            else {
                Snackbar.make(contextView!!, viewModel.shareStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    "Probeer opnieuw"
                )
                {
                }.show()
            }
        })

        viewModel.completedStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Toast.makeText(
                    context,
                    "Je doel is behaald",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Snackbar.make(contextView!!, viewModel.completedStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    "Probeer opnieuw"
                )
                {
                }.show()
            }
        })

        viewModel.removeStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Toast.makeText(
                    context,
                    "Je doel is verwijderd",
                    Toast.LENGTH_LONG
                ).show()
            }
            else {
                Snackbar.make(contextView!!, viewModel.removeStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    "Probeer opnieuw"
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

