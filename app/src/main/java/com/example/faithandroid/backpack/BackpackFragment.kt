package com.example.faithandroid.backpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.databinding.BackpackBinding
import com.example.faithandroid.treasureChest.TreasureChestPostAdapter
import com.example.faithandroid.treasureChest.TreasureChestViewModel
import com.google.android.material.snackbar.Snackbar


class BackpackFragment: Fragment() {

    private lateinit var viewModel: BackpackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<BackpackBinding>(
          inflater,
          R.layout.backpack,
          container,
          false
      );

        binding.BackpackRecycler.adapter = BackpackPostAdapter()

        viewModel = ViewModelProvider(this).get(BackpackViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.getPostsOfBackpack()
                }.show()
            }
        })
        return binding.root
    }
}