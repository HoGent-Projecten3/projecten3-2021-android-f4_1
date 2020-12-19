package com.example.faithandroid.post.text

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faithandroid.*
import com.example.faithandroid.bulletinboard.BulletinBoardViewModel
import com.example.faithandroid.databinding.AddNewTextBinding
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import com.google.android.material.snackbar.Snackbar


class TextPostToevoegenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val args: TextPostToevoegenFragmentArgs by navArgs()
    val postRepository : PostRepository by inject()
    private val postViewModel: PostViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory(args.placeType,postRepository)).get(PostViewModel::class.java)
    }

    //private lateinit var bulletinBoardViewModel: BulletinBoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<AddNewTextBinding>(inflater,
            R.layout.add_new_text, container, false);
        bulletinBoardViewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)

        postViewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            Snackbar.make(contextView!!, postViewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                ""
            )
            {
            }.show()
        })
        binding.placeType = "nieuwe post toevoegen aan " + args.placeType.toString()

        binding.textPostToevoegen.setOnClickListener{ view: View ->

            try
            {
                val post: Post = Post(0, binding.textposttitel.text.toString(), binding.textposttext.text.toString(), LocalDateTime.now().toString(), PostType.Text.ordinal,"","",
                    backpack = false,
                    bulletinBoard = false,
                    treasureChest = false
                )

                when (args.placeType){
                    PlaceType.Prikbord ->{
                        post.bulletinBoard = true
                    }
                    PlaceType.Schatkist ->{
                        post.treasureChest = true
                    }
                    PlaceType.Rugzak ->{
                        post.backpack = true
                    }
                }
                if(postViewModel.addPostByEmail(post, args.placeType))
                {

                    when (args.placeType) {
                        PlaceType.Prikbord ->   view.findNavController().navigate(R.id.action_text_post_toevoegen_to_bulletinBoardFragment)
                        PlaceType.Schatkist -> view.findNavController().navigate(R.id.action_text_post_toevoegen_to_treasureChestFragment)
                        PlaceType.Rugzak -> view.findNavController().navigate(R.id.action_text_post_toevoegen_to_backpackFragment)
                        else -> { // Note the block

                        }
                    }
                }

            }
            catch (e: Exception)
            {
                postViewModel.status = MutableLiveData("Er liep iets mis met een bestaande post toevoegen")
            }
        }

        return binding.root
    }


}