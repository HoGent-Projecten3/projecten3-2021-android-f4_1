
package com.example.faithandroid.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.databinding.BillboardBinding


class BillboardFragment: Fragment() {

    private lateinit var viewModel: BillboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val binding = DataBindingUtil.inflate<BillboardBinding>(
          inflater,
          R.layout.billboard,
          container,
          false
      );


        viewModel = ViewModelProvider(this).get(BillboardViewModel::class.java)
        binding.viewmodelBillboard = viewModel

        binding.billboardGridView.adapter = BillboardGridAdapter()
        return binding.root
    }
}