package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.databinding.FragmentGoaldetailsBinding
import com.example.faithandroid.databinding.FragmentMusicroomBinding
import com.example.faithandroid.viewmodels.MusicRoomViewModel

class goalDetailsFragment:Fragment() {
    //private lateinit var viewModel: MusicRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGoaldetailsBinding>(
            inflater,
            R.layout.fragment_goaldetails,
            container,
            false
        );
        return binding.root
    }
}