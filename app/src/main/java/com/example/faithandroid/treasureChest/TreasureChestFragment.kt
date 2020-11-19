package com.example.faithandroid.treasureChest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.databinding.TreasurechestBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


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

        binding.TreasureChestRecycler.adapter = TreasureChestPostAdapter()

        viewModel = ViewModelProvider(this).get(TreasureChestViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.getPostsOfTreasureChest()
                }.show()
            }
        })

        return binding.root
    }
}