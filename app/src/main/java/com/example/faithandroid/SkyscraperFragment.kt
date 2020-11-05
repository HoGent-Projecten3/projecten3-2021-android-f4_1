package com.example.faithandroid

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.databinding.FragmentSkyscraperBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import com.example.faithandroid.viewmodels.SkyscraperViewModel
import kotlinx.android.synthetic.main.textpost.view.*


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

        binding.AddPostButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_skyscraperFragment_to_addGoalFragment)

        }

        viewModel.testLive.observe(this.viewLifecycleOwner, Observer{goals ->
            goals.forEach{goal ->
                val rowView: View = inflater.inflate(R.layout.goalpostimage, null)
                binding.lijst.addView(rowView, binding.lijst.childCount - 1)
            }
        })
        viewModel.test.forEach{goal ->
            val rowView: View = inflater.inflate(R.layout.goalpostimage, null)
            binding.lijst.addView(rowView, binding.lijst.childCount - 1)
        }
        return binding.root
    }
}