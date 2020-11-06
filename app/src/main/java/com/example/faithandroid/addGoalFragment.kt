package com.example.faithandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentAddGoalBinding
import com.example.faithandroid.databinding.FragmentMusicroomBinding
import com.example.faithandroid.models.GoalPost
import com.example.faithandroid.viewmodels.MusicRoomViewModel
import com.example.faithandroid.viewmodels.SkyscraperViewModel
import kotlinx.android.synthetic.main.fragment_add_goal.*
import org.threeten.bp.LocalDateTime

class addGoalFragment : Fragment() {

    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAddGoalBinding>(
            inflater,
            R.layout.fragment_add_goal,
            container,
            false
        );




        binding.annuleerButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_addGoalFragment_to_skyscraperFragment)
        }

        binding.voegToeButton.setOnClickListener { view: View ->
//            var titel : String = binding.titelText.text.toString()
//            var beschrijving : String = binding.beschrijvingText.text.toString()
//            var steps : List<String> = emptyList();
//            binding.stepList.children.forEach { step: View ->
//                steps.plus(step.toString());
//            }
//            var newGoal = GoalPost(titel, beschrijving, false, steps, "ZOLLAT")
//
//
//
//
//            viewModel.addGoalPost(newGoal);
//            Log.d("helpGF", viewModel.testLive.value.toString())
//
//
//
//
//            view.findNavController().navigate(R.id.action_addGoalFragment_to_skyscraperFragment)
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