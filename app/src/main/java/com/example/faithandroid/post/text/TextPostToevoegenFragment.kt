package com.example.faithandroid.post.text

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.data.local.PostDao
import com.example.faithandroid.data.local.PostLocalDataSource
import com.example.faithandroid.data.remote.PostRemoteDataSource
import com.example.faithandroid.databinding.AddNewTextBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.network.FaithApi
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel


class TextPostToevoegenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var postDao: PostDao
    val args: TextPostToevoegenFragmentArgs by navArgs()
    /*private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(args.placeType, PostRepository(
            PostLocalDataSource(postDao),
            PostRemoteDataSource(FaithApi)
        )
        )).get(PostViewModel::class.java)
    }*/

    //private lateinit var bulletinBoardViewModel: BulletinBoardViewModel

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

        var binding = DataBindingUtil.inflate<AddNewTextBinding>(inflater,
            R.layout.add_new_text, container, false);
        //bulletinBoardViewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)
        binding.placeType = "nieuwe post toevoegen aan " + args.placeType.toString()

        binding.textPostToevoegen.setOnClickListener{ view: View ->

            try
            {

                val post: Post = Post(0, binding.textposttitel.text.toString(), binding.textposttext.text.toString(), "2020-11-05T22:34:57.61", PostType.Text.ordinal)
                /*if(postViewModel.addPostByEmail(post, args.placeType, "dora.theexplorer1999@gmail.com"))
                {

                    when (args.placeType) {
                        PlaceType.Prikbord ->   view.findNavController().navigate(R.id.action_text_post_toevoegen_to_bulletinBoardFragment)
                        PlaceType.Schatkist -> view.findNavController().navigate(R.id.action_text_post_toevoegen_to_treasureChestFragment)
                        PlaceType.Rugzak -> view.findNavController().navigate(R.id.action_text_post_toevoegen_to_backpackFragment)
                        else -> { // Note the block

                        }
                    }
                }*/

            }
            catch (e: Exception)
            {
                throw e
            }
        }

        return binding.root
    }


}