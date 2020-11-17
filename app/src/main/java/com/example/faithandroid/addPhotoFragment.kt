package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.databinding.AddPhotoBinding
import com.example.faithandroid.databinding.BulletinboardBinding
import com.example.faithandroid.databinding.CinemaBinding

class addPhotoFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddPhotoBinding>(
            inflater,
            R.layout.add_photo,
            container,
            false
        );
        return binding.root
    }
}