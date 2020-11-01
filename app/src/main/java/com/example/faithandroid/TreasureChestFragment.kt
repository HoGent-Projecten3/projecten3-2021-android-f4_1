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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.databinding.FragmentTreasurechestBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import com.example.faithandroid.viewmodels.TreasureChestViewModel
import kotlinx.android.synthetic.main.textpost.view.*


class TreasureChestFragment: Fragment() {

    private lateinit var viewModel: TreasureChestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<FragmentTreasurechestBinding>(
          inflater,
          R.layout.fragment_treasurechest,
          container,
          false
      );
        return binding.root
    }
}