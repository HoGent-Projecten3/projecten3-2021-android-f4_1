package com.example.faithandroid.skyscraper

import android.graphics.Color
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
import com.example.faithandroid.LoadingFragment
import com.example.faithandroid.R
//import com.example.faithandroid.SkyscraperDirections
import com.example.faithandroid.databinding.SkyscraperBinding
import com.example.faithandroid.util.Status
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.skyscraper_goalpostimage.view.*
import org.koin.android.ext.android.inject


class SkyscraperFragment: Fragment() {

<<<<<<< HEAD
<<<<<<< HEAD
    private val loadingDialogFragment by lazy { LoadingFragment() }
=======
>>>>>>> 1ae52e1 (repository deel goal niet af)
=======
    private val loadingDialogFragment by lazy { LoadingFragment() }
>>>>>>> 8b69d0a (repository spotify + posts niet af)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel : SkyscraperViewModel by inject()
      val binding = DataBindingUtil.inflate<SkyscraperBinding>(
          inflater,
          R.layout.skyscraper,
          container,
          false
      );

        //viewModel = ViewModelProvider(this).get(SkyscraperViewModel::class.java)

        viewModel.getStatus.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.getStatus.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                }.show()
            }
        })



        binding.AddPostButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_skyscraperFragment_to_addGoalFragment)

        }

        //viewModel.getPostsOfSkyscraper()

        /*viewModel.testLive.observe(this.viewLifecycleOwner, Observer{
            it.forEach{goal ->
                val rowView: View = inflater.inflate(R.layout.skyscraper_goalpostimage, null)
                rowView.titleText.text = goal.title

                if(goal.completed){
                    rowView.cardGoal.setBackgroundColor(Color.rgb(161, 214,134 ))
                } else {
                    rowView.cardGoal.setBackgroundColor(Color.WHITE)
                }
                rowView.layout.setOnClickListener{view: View ->

                    val action =
                        SkyscraperFragmentDirections.actionSkyscraperFragmentToGoalDetailsFragment(
                            goal
                        )
                    view.findNavController().navigate(action)
                    }
                    binding.lijst.addView(rowView, 1)
                }
            })*/

        viewModel.testLive.observe(this.viewLifecycleOwner, Observer
        {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
<<<<<<< HEAD
<<<<<<< HEAD
                        showProgress(false)
                        binding.lijst.removeViews(1,binding.lijst.childCount - 2)
=======
>>>>>>> 1ae52e1 (repository deel goal niet af)
=======
                        showProgress(false)
>>>>>>> 8b69d0a (repository spotify + posts niet af)
                        resource.data?.forEach { goal ->
                            val rowView: View = inflater.inflate(R.layout.skyscraper_goalpostimage, null)
                            rowView.titleText.text = goal.title

                            if(goal.completed){
                                rowView.cardGoal.setBackgroundColor(Color.rgb(161, 214,134 ))
                            } else {
                                rowView.cardGoal.setBackgroundColor(Color.WHITE)
                            }
                            rowView.layout.setOnClickListener{view: View ->

                                val action =
                                    SkyscraperFragmentDirections.actionSkyscraperFragmentToGoalDetailsFragment(
                                        goal
                                    )
                                view.findNavController().navigate(action)
                            }
                            binding.lijst.addView(rowView, 1)
                        }
                    }
                    Status.LOADING -> {
<<<<<<< HEAD
<<<<<<< HEAD
                        showProgress(true)
                    }
                    Status.ERROR -> {
                        showProgress(false)
=======
                        //showProgress(true)
                    }
                    Status.ERROR -> {
                        //showProgress(false)
>>>>>>> 1ae52e1 (repository deel goal niet af)
=======
                        showProgress(true)
                    }
                    Status.ERROR -> {
                        showProgress(false)
>>>>>>> 8b69d0a (repository spotify + posts niet af)
                    }
                }
            }
        })

        return binding.root
    }

    private fun showProgress(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }

<<<<<<< HEAD
   /* override fun onStart(){
=======
    override fun onStart(){
>>>>>>> 8b69d0a (repository spotify + posts niet af)
        super.onStart()

        viewModel.getPostsOfSkyscraper()
    }


    override fun onResume() {
        super.onResume()

        viewModel.getPostsOfSkyscraper()
    }*/


}