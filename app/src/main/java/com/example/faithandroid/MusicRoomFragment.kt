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
import com.example.faithandroid.databinding.FragmentMusicroomBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import com.example.faithandroid.viewmodels.MusicRoomViewModel
import kotlinx.android.synthetic.main.textpost.view.*


class MusicRoomFragment: Fragment() {

    private lateinit var viewModel: MusicRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<FragmentMusicroomBinding>(
          inflater,
          R.layout.fragment_musicroom,
          container,
          false
      );
        return binding.root
    }
}