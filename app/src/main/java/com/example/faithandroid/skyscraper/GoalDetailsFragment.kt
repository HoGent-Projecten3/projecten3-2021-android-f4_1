package com.example.faithandroid.skyscraper

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.R
import com.example.faithandroid.databinding.SkyscraperGoaldetailsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*
import org.koin.android.ext.android.inject
import java.time.LocalDateTime

/**
 * This is a fragment for the details of a goal
 *
 * @property args is used to store the goal
 * @property viewModel is the viewmodel for skyscraper
 */
class GoalDetailsFragment : DialogFragment() {
    val args: GoalDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val application = requireNotNull(activity).application

        // viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)
        val viewModel: SkyscraperViewModel by inject()
        val binding = DataBindingUtil.inflate<SkyscraperGoaldetailsBinding>(
            inflater,
            R.layout.skyscraper_goaldetails,
            container,
            false
        )
        // binding.lifecycleOwner = this

        // val faithProperty = goalDetailsFragmentArgs.fromBundle(requireArguments()).title

        binding.titelText.text = args.goal.title
        binding.beschrijvingText.text = args.goal.description
        binding.goalShared = args.goal.shared
        binding.goalDetail = args.goal.completed

        var localdate = LocalDateTime.parse(args.goal.date)
        var date = localdate.dayOfMonth.toString() + " " + localdate.month.toString() + " " + localdate.year.toString()
        binding.datumText.text = date

        binding.btnBehaald.setOnClickListener { view: View ->
            viewModel.goalBehaald(args.goal.id)
            Toast.makeText(
                context,
                "Je doel is behaald",
                Toast.LENGTH_LONG
            ).show()
            view.findNavController().navigate(R.id.skyscraperFragment)
        }

        binding.btnDelen.setOnClickListener { view: View ->
            viewModel.shareGoal(args.goal.id)
           view.findNavController().navigate(R.id.billboardFragment)
            Toast.makeText(
                context,
                "Je doel is gedeeld",
                Toast.LENGTH_LONG
            ).show()
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
                        Toast.makeText(
                            context,
                            "Je doel is verwijderd",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    .setNegativeButton("Nee") { _, which ->
                        // nothing has to happen here
                    }.show()
            } else if (args.goal.completed) {
              Snackbar.make(view, "Deze goal is behaald, u kan deze dus niet verwijderen.", Snackbar.LENGTH_SHORT).setAction(
                  ""
              ) {
              }.show()
        } else {
                viewModel.deleteGoal(args.goal.id)
              Toast.makeText(
                  context,
                  "Je doel is verwijderd",
                  Toast.LENGTH_LONG
              ).show()
                view.findNavController().navigate(R.id.skyscraperFragment)
            }
        }

        viewModel.getStatus.observe(
            this.viewLifecycleOwner,
            Observer {
                val contextView = this.view

                        Snackbar.make(contextView!!, viewModel.getStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                            "Probeer opnieuw"
                        ) {
                }.show()
            }
        )

        args.goal.steps.forEach { step ->
            val textView = TextView(context)
            textView.text = step.stepText
            binding.stepList.addView(textView)
        }

        return binding.root
    }
}
