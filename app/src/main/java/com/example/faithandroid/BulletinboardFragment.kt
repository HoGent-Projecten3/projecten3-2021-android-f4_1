package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.databinding.DataBindingUtil
//import com.example.faithandroid.databinding.FragmentBulletinboardBinding


class BulletinboardFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
     //  val binding : FragmentBulletinboardBinding = DataBindingUtil.inflate()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}