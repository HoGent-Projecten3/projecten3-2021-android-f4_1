package com.example.faithandroid.profiel

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.ProfielBinding


class profielFragment: Fragment() {

    private lateinit var viewModel: ProfielViewModel
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