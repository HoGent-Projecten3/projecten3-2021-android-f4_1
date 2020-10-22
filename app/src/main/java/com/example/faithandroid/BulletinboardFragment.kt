package com.example.faithandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import kotlinx.android.synthetic.main.fragment_bulletinboard.*


class BulletinboardFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      val binding = DataBindingUtil.inflate<FragmentBulletinboardBinding>(inflater, R.layout.fragment_bulletinboard, container, false);
        return binding.root
    }
}