
package com.example.faithandroid

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.faithandroid.databinding.FragmentBillboardBinding
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.viewmodels.BillboardViewModel
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import kotlinx.android.synthetic.main.textpost.view.*


class BillboardFragment: Fragment() {

    private lateinit var viewModel: BillboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val binding = DataBindingUtil.inflate<FragmentBillboardBinding>(
          inflater,
          R.layout.fragment_billboard,
          container,
          false
      );


        viewModel = ViewModelProvider(this).get(BillboardViewModel::class.java)
        binding.viewmodelBillboard = viewModel

        binding.billboardGridView.adapter = BillboardGridAdapter()
        return binding.root
    }
}