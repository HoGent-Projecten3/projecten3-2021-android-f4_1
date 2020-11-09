package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.LoginBinding
import com.example.faithandroid.databinding.BulletinboardOptionsAddPostBinding

class OptionsAddPostFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<BulletinboardOptionsAddPostBinding>(
            inflater,
            R.layout.bulletinboard_options_add_post,
            container,
            false
        );
        binding.annulerenPost.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_optionsAddPostFragment_to_bulletinBoardFragment)
        }

        binding.TekstButton.setOnClickListener{
                view: View -> view.findNavController().navigate(R.id.action_optionsAddPostFragment_to_text_post_toevoegen)
        }



        return binding.root

    }

}