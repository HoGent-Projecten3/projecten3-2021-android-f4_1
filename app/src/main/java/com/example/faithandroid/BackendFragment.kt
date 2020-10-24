package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.databinding.GewoonEenTestVoorDeBackendBinding

class BackendFragmentFragment : Fragment() {

    private lateinit var viewModel: OverviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)
        val binding = DataBindingUtil.inflate<GewoonEenTestVoorDeBackendBinding>(inflater, R.layout.fragment_blank, container, false);
        return binding.root
    }


}