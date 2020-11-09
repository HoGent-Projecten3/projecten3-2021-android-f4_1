package com.example.faithandroid.musicRoom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.MusicroomBinding


class MusicRoomFragment: Fragment() {

    private lateinit var viewModel: MusicRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<MusicroomBinding>(
          inflater,
          R.layout.musicroom,
          container,
          false
      );
        return binding.root
    }
}