package com.example.faithandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.databinding.BulletinboardTextPostToevoegenBinding
import com.example.faithandroid.bulletinboard.BulletinBoardViewModel
import com.example.faithandroid.models.Post
import org.threeten.bp.LocalDateTime


class TextPostToevoegenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val args: TextPostToevoegenFragmentArgs by navArgs()

    private lateinit var bulletinBoardViewModel: BulletinBoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding = DataBindingUtil.inflate<BulletinboardTextPostToevoegenBinding>(inflater, R.layout.bulletinboard_text_post_toevoegen, container, false);
        bulletinBoardViewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)
        binding.placeType = "nieuwe post toevoegen aan " + args.placeType.toString()

        binding.textPostToevoegen.setOnClickListener{ view: View ->

            try
            {
                val post: Post = Post(0, binding.textposttitel.text.toString(), binding.textposttext.text.toString(), "testTime")

                //viewModel.test.add(TextPost(binding.textposttitel.text.toString(), binding.textposttext.text.toString()))
                when (args.placeType) {
                    PlaceType.Prikbord -> {
                        bulletinBoardViewModel.addNewPostToBulletinBoard(post)
                        view.findNavController()
                            .navigate(R.id.action_text_post_toevoegen_to_bulletinBoardFragment)
                    }

                    else -> { // Note the block
                        Log.d("postError", "when mislukt")
                    }
                }
            }
            catch (e: Exception)
            {
                throw e
            }
        }

        return binding.root
    }


}