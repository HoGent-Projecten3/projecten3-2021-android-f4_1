package com.example.faithandroid.skyscraper

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.R
import com.example.faithandroid.SkyscraperFragmentDirections
import com.example.faithandroid.databinding.FragmentSkyscraperBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.goalpostimage.view.*


class SkyscraperFragment: Fragment() {

    private lateinit var viewModel: SkyscraperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<FragmentSkyscraperBinding>(
          inflater,
          R.layout.fragment_skyscraper,
          container,
          false
      );

        viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.GetPostsOfSkyscraper("dora.theexplorer1999@gmail.com")
                }.show()
            }
        })



        binding.AddPostButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_skyscraperFragment_to_addGoalFragment)

        }

        viewModel.testLive.observe(this.viewLifecycleOwner, Observer{
            viewModel.testLive.value?.forEach{goal ->
                val rowView: View = inflater.inflate(R.layout.goalpostimage, null)
                rowView.titleText.text = goal.title
                rowView.layout.setOnClickListener{view: View ->
                    Log.d("CLICK", "hewwo? Mw obwama?")
                    val action =
                        SkyscraperFragmentDirections.actionSkyscraperFragmentToGoalDetailsFragment(
                            goal
                        )
                    view.findNavController().navigate(action)
                    }
                    binding.lijst.addView(rowView, 1)
                }
            })





//        viewModel.test.forEach{goal ->
//            val rowView: View = inflater.inflate(R.layout.goalpostimage, null)
//            binding.lijst.addView(rowView, binding.lijst.childCount - 1)
//        }
        return binding.root
    }
}