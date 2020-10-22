package com.example.faithandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import kotlinx.android.synthetic.main.fragment_bulletinboard.*
import kotlinx.android.synthetic.main.textpost.view.*


class BulletinboardFragment: Fragment() {

    private lateinit var viewModel: BulletinBoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      val binding = DataBindingUtil.inflate<FragmentBulletinboardBinding>(inflater, R.layout.fragment_bulletinboard, container, false);


        binding.AddPostButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_bulletinBoardFragment_to_optionsAddPostFragment)


        }

        viewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)


        viewModel.test.forEach{lala ->
//            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView: View = inflater.inflate(R.layout.textpost, null)
            rowView.bulletinboardTittle.text = lala.title
            rowView.bulletinboardInhoud.text = lala.text
            binding.bulletinLayout.addView(rowView, binding.bulletinLayout.childCount - 1)

        }


        return binding.root
    }
}