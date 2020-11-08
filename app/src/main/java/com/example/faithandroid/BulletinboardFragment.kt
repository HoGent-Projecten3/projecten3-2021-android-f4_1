package com.example.faithandroid

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.textpost.view.*


class BulletinboardFragment: Fragment() {

    private lateinit var viewModel: BulletinBoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<FragmentBulletinboardBinding>(
          inflater,
          R.layout.fragment_bulletinboard,
          container,
          false
      );

        binding.BulletinBoardRecycler.adapter = BulletinBoardPostAdapter()

        binding.requestConsultationButton.setOnClickListener {
            val intent = Intent(this.context, PopupWindow::class.java)
            intent.putExtra("popuptitle", "Aanvraag Gesprek")
            intent.putExtra("popuptext", "Uw gesprek werd aangevraagd! \n Uw begeleider zal een melding ontvangen.")
            intent.putExtra("popupbtn", "OK")
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)
        }

        binding.AddPostButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_bulletinBoardFragment_to_optionsAddPostFragment)
        }

        viewModel = ViewModelProvider(this).get(BulletinBoardViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.status.observe(this.viewLifecycleOwner, Observer {
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(R.string.tryAgain)
                {
                    viewModel.getPostsOfBulletinBoard()
                }.show()
            }
        })
        return binding.root
    }
}