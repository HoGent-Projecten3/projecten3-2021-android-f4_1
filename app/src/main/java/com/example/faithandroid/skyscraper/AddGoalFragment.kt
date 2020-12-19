package com.example.faithandroid.skyscraper

import android.content.res.ColorStateList
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
import androidx.core.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.R
import com.example.faithandroid.databinding.SkyscraperAddGoalBinding
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.app_bar_main.view.*
import kotlinx.android.synthetic.main.skyscraper_add_goal.*
import kotlinx.android.synthetic.main.skyscraper_add_goal.view.*
import kotlinx.android.synthetic.main.skyscraper_add_goal.view.stepList
import kotlinx.android.synthetic.main.skyscraper_goaldetails.view.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.function.Consumer

class addGoalFragment : Fragment() {

    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<SkyscraperAddGoalBinding>(
            inflater,
            R.layout.skyscraper_add_goal,
            container,
            false
        );

        viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)


        binding.annuleerButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_addGoalFragment_to_skyscraperFragment)
        }

        
        binding.voegToeButton.setOnClickListener { view: View ->
            var titel : String = binding.titleDoelText.text.toString()
            var beschrijving : String = binding.descriptionDoelText.text.toString()
            var steps : List<Step> = mutableListOf()
            var offsteps : List<Step> = mutableListOf()
            for ( i in binding.stepList.children) {
                var t: TextView
                t = i as TextView
                val stepsss = t.text.trim().split(" - ")
                for (n in stepsss.indices) {
                    val stap: Step = Step(0, stepsss[n])
                    offsteps += stap
                }
            }
            var datum = LocalDateTime.now()
            var newGoal = GoalPost(0, titel, beschrijving, false, offsteps, datum.toString())


            viewModel.postNewGoalPost(newGoal);
            Toast.makeText(
                context,
                "Je doel is toegevoegd!",
                Toast.LENGTH_LONG
            ).show()
            view.findNavController().navigate(R.id.action_addGoalFragment_to_skyscraperFragment)
        }

        binding.addStepButton.setOnClickListener{run{
                //innerStepList.add
                var newView: TextView = TextView(this.context);
                newView.text =  " - " + binding.stepText.text;
                binding.stepText.text.clear()
                newView.setOnClickListener{
                    run{
                        stepList.removeView(newView)
                    }
                }
                //stepList.add(newView)
                binding.stepList.addView(newView, binding.stepList.childCount - 1)
            }
        }

        viewModel.getStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view

            Snackbar.make(contextView!!, viewModel.getStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                ""
            )
            {
            }.show()


        })


        return binding.root
    }
}


