package com.example.faithandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.faithandroid.databinding.GewoonEenTestVoorDeBackendBinding

class BackendFragment : Fragment() {

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
        //val binding = DataBindingUtil.inflate<GewoonEenTestVoorDeBackendBinding>(inflater, R.layout.gewoon_een_test_voor_de_backend, container, false);
        val binding = GewoonEenTestVoorDeBackendBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        //binding.viewModel = viewModel
        binding.nameGrid.adapter = FirstNameGridAdapter()
        binding.viewModellalala = viewModel
       /* viewModel.properties.observe(viewLifecycleOwner, Observer{
            var sb = StringBuilder();
            viewModel.properties.value?.forEach{ property ->
                sb.append(property.firstName)
            }
            binding.nameGrid.Recycler().scrapList

        })*/

        return binding.root
    }


}