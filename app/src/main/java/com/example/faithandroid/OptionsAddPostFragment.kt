package com.example.faithandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.bulletinboard.BulletinboardFragmentDirections
import com.example.faithandroid.databinding.LoginBinding
import com.example.faithandroid.databinding.BulletinboardOptionsAddPostBinding
import com.example.faithandroid.skyscraper.GoalDetailsFragmentArgs

class OptionsAddPostFragment: Fragment() {

    val args: OptionsAddPostFragmentArgs by navArgs()
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


        /**
         * navigate to options for texts posts
         */
        binding.TekstButton.setOnClickListener{
                view: View ->  val action =
            OptionsAddPostFragmentDirections.actionOptionsAddPostFragmentToTextPostToevoegen(
                args.placeType
            )
            view.findNavController().navigate(action)
        }


        /**
         * navigate to options for audio posts
         */
        binding.AudioButton.setOnClickListener {

        }

        /**
         * navigate to options for images posts
         */
        binding.FotoButton.setOnClickListener {
            view: View -> val action =
            OptionsAddPostFragmentDirections.actionOptionsAddPostFragmentToAddPhotoFragment(
                args.placeType
            )
            view.findNavController().navigate(action)

        }

        /**
         * navigate to options for video posts
         */
        binding.VideoButton.setOnClickListener {
          view: View -> val action = OptionsAddPostFragmentDirections.actionOptionsAddPostFragmentToVideoToevoegenFragment()
            view.findNavController().navigate(action)

        }

        return binding.root

    }

}