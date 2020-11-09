package com.example.faithandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.BulletinboardTextPostToevoegenBinding
import com.example.faithandroid.bulletinboard.BulletinBoardViewModel

class TextPostToevoegenFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewModel: BulletinBoardViewModel

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
        viewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)


        binding.textPostToevoegen.setOnClickListener{ view: View ->

            //viewModel.test.add(TextPost(binding.textposttitel.text.toString(), binding.textposttext.text.toString()))

            view.findNavController()
                .navigate(R.id.action_text_post_toevoegen_to_bulletinBoardFragment)
        }

        return binding.root
    }


}