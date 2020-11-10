package com.example.faithandroid.treasureChest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.TreasurechestBinding


class TreasureChestFragment: Fragment() {

    private lateinit var viewModel: TreasureChestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<TreasurechestBinding>(
          inflater,
          R.layout.treasurechest,
          container,
          false
      );
        return binding.root
    }
}