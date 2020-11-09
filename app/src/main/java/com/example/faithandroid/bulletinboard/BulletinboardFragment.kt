package com.example.faithandroid.bulletinboard

import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.PopupWindow
import com.example.faithandroid.R
import com.example.faithandroid.databinding.BulletinboardBinding
import com.google.android.material.snackbar.Snackbar


class BulletinboardFragment: Fragment() {

    private lateinit var viewModel: BulletinBoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val binding = DataBindingUtil.inflate<BulletinboardBinding>(
          inflater,
          R.layout.bulletinboard,
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
                Snackbar.make(contextView, viewModel.status.value.toString(), Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.getPostsOfBulletinBoard()
                }.show()
            }
        })

        return binding.root
    }
}