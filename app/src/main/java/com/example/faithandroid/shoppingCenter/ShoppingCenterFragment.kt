package com.example.faithandroid.shoppingCenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.FragmentShoppingcenterBinding


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