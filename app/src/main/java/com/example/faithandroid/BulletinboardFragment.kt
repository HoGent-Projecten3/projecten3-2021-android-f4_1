package com.example.faithandroid

import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.FragmentBulletinboardBinding
import com.example.faithandroid.viewmodels.BulletinBoardViewModel
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


//        viewModel.test.forEach{ lala ->
////            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val rowView: View = inflater.inflate(R.layout.textpost, null)
//            var kortestring = lala.text.substring(0, 30) + "..."
//            rowView.bulletinboardTittle.text = lala.title
//            rowView.bulletinboardInhoud.text = kortestring
//            rowView.bulletinboardOpenButton.setOnClickListener{view: View ->
//                rowView.bulletinboardInhoud.text = lala.text
//            }
//            rowView.bulletinboardUnpinButton.setOnClickListener{view:View ->
//                binding.bulletinLayout.removeView(rowView);
//            }
//            binding.bulletinLayout.addView(rowView, binding.bulletinLayout.childCount - 1)
//
//        }

       /* binding.requestConsultationButton.setOnClickListener() {
            val intent = Intent(MainActivity.this, PopupWindow::class.java)
            intent.putExtra("popuptitle", "Aanvraag Gesprek")
            intent.putExtra("popuptext", "Uw gesprek werd aangevraagd! \n Uw begeleider zal een melding ontvangen.")
            intent.putExtra("popupbtn", "OK")
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)
        }*/


        return binding.root
    }
}