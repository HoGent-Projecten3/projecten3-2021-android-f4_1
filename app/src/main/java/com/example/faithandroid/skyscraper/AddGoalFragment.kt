package com.example.faithandroid.skyscraper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.R
import com.example.faithandroid.databinding.SkyscraperAddGoalBinding
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.models.Step
import kotlinx.android.synthetic.main.skyscraper_add_goal.*

class addGoalFragment : Fragment() {

    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            var titel : String = binding.titelText.text.toString()
            var beschrijving : String = binding.beschrijvingText.text.toString()
            var steps : List<Step> = emptyList();
            binding.stepList.children.forEach { step: View ->
                steps.plus(Step(0, step.toString()));
            }
            var newGoal = GoalPost(0, titel, beschrijving, false, steps, "2020-11-05T22:34:57.61")

            //var newPost : TextPost = TextPost(titel, beschrijving)


            //viewModel.postNewGoalPost("dora.theexplorer1999@gmail.com",newGoal);





            view.findNavController().navigate(R.id.action_addGoalFragment_to_skyscraperFragment)
        }

        binding.addStepButton.setOnClickListener{run{
                //innerStepList.add
                var newView: TextView = TextView(this.context);
                newView.text =  " - " + binding.stepTekst.text;
                binding.stepTekst.text.clear()
                newView.setOnClickListener{
                    run{
                        stepList.removeView(newView)
                    }
                }
                //stepList.add(newView)
                binding.stepList.addView(newView, binding.stepList.childCount - 1)
            }
        }


        return binding.root
    }
}