package com.example.faithandroid.profiel

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.bulletinboard.BulletinBoardViewModel
import com.example.faithandroid.databinding.ProfielBinding
import com.example.faithandroid.models.Adolescent
import com.google.android.material.snackbar.Snackbar


class profielFragment: Fragment() {

    private lateinit var viewModel: ProfielViewModel
    private var adolescent: Adolescent? = null
    private var m_Text = ""
    private lateinit var binding: ProfielBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //checkTheme()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ProfielBinding>(
            inflater,
            R.layout.profiel,
            container,
            false
        );


        binding.wachtwoordWIjzigen.setOnClickListener {

            viewModel = ViewModelProvider(this).get(ProfielViewModel::class.java)

            viewModel.getAdolescent()

            viewModel.adol.observe(viewLifecycleOwner, Observer {
                adolescent = it
                binding.profielNaam.text =
                    String.format(adolescent?.firstName + " " + adolescent?.name)
                binding.profielEmail.text = adolescent?.email
            })

            binding.wachtwoordWIjzigen.setOnClickListener() {

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
            val toggle: SwitchCompat = binding.donkereModus
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    MyPreference(this.context).darkMode = 0
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    MyPreference(this.context).darkMode = 1
                }
            }
            return binding.root
        }


        private fun checkTheme() {
            when (MyPreference(this.context).darkMode) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
            }
        }


}