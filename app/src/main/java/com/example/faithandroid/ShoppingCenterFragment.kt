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
import com.example.faithandroid.databinding.FragmentShoppingcenterBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import com.example.faithandroid.viewmodels.ShoppingCenterViewModel
import kotlinx.android.synthetic.main.textpost.view.*


class ShoppingCenterFragment: Fragment() {

    private lateinit var viewModel: ShoppingCenterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<FragmentShoppingcenterBinding>(
          inflater,
          R.layout.fragment_shoppingcenter,
          container,
          false
      );
        return binding.root
    }
}