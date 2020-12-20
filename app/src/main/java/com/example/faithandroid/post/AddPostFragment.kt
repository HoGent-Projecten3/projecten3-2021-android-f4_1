package com.example.faithandroid.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.R
import com.example.faithandroid.databinding.AddPostBinding

/**
 * This is a fragment for adding a post
 *
 * @property args is used to store the placetype
 */
class AddPostFragment : Fragment() {
    val args: AddPostFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<AddPostBinding>(
            inflater,
            R.layout.add_post,
            container,
            false
        )

        /**
         * navigate to options for texts posts
         */
        binding.TekstButton.setOnClickListener {
                view: View -> val action =
            AddPostFragmentDirections.actionOptionsAddPostFragmentToAddTextFragment(
                args.placeType
            )
            view.findNavController().navigate(action)
        }

        /**
         * navigate to options for audio posts
         */
        binding.AudioButton.setOnClickListener {
            view: View -> val action =
            AddPostFragmentDirections.actionOptionsAddPostFragmentToAudioToevoegenFragment(
                args.placeType
            )
            view.findNavController().navigate(action)
        }

        /**
         * navigate to options for images posts
         */
        binding.FotoButton.setOnClickListener {
            view: View -> val action =
            AddPostFragmentDirections.actionOptionsAddPostFragmentToAddPhotoFragment(
                args.placeType
            )
            view.findNavController().navigate(action)
        }

        /**
         * navigate to options for video posts
         */
        binding.VideoButton.setOnClickListener {
          view: View -> val action =
            AddPostFragmentDirections.actionOptionsAddPostFragmentToVideoToevoegenFragment(
                args.placeType
            )
            view.findNavController().navigate(action)
        }

        return binding.root
    }
}
