package com.example.faithandroid.profiel

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.bulletinboard.BulletinBoardViewModel
import com.example.faithandroid.databinding.ProfielBinding
import com.example.faithandroid.models.Adolescent
import com.google.android.material.snackbar.Snackbar


class profielFragment: Fragment() {

    private lateinit var viewModel: ProfielViewModel
    private lateinit var adolescent: Adolescent
    private var m_Text = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ProfielBinding>(
            inflater,
            R.layout.profiel,
            container,
            false
        );

        try {
            viewModel = ViewModelProvider(this).get(ProfielViewModel::class.java)

            adolescent = viewModel.getAdolescent()
            Log.d("UserFrag", adolescent.toString())
            binding.profielNaam.text = String.format(adolescent.firstName + " " + adolescent.name)
            binding.profielEmail.text = adolescent.email
        }catch(e: Exception){
            this.view?.let { view ->

                    Snackbar.make(view, e.message.toString(), Snackbar.LENGTH_SHORT)
                        .show()
            }
        }

        binding.wachtwoordWIjzigen.setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("Wachtwoord wijzigen")

            val viewInflated: View = LayoutInflater.from(context)
                .inflate(R.layout.profiel_changepassword, view as ViewGroup?, false)

            val input = viewInflated.findViewById<View>(R.id.nieuwwwfld) as EditText

            builder.setView(viewInflated)

            builder.setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    m_Text = input.text.toString()
                })
            builder.setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

            builder.show()
        }
        return binding.root
    }
}