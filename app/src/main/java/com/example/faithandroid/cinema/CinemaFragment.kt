package com.example.faithandroid.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.CinemaBinding


class CinemaFragment: Fragment() {

    private lateinit var viewModel: CinemaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<CinemaBinding>(
          inflater,
          R.layout.cinema,
          container,
          false
      );
        return binding.root
    }
}