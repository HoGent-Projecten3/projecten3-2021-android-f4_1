package com.example.faithandroid.profiel

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.databinding.ProfielBinding
import com.example.faithandroid.models.Adolescent


class ProfielFragment: Fragment() {

    private var adolescent: Adolescent? = null
    private lateinit var viewModel: ProfielViewModel
    private var nieuwww = ""
    private var nieuwcon = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //checkTheme()
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

        viewModel = ViewModelProvider(this).get(ProfielViewModel::class.java)
        viewModel.getAdolescent()

        viewModel.adol.observe(viewLifecycleOwner, Observer {
            adolescent = it
            binding.profielNaam.text = String.format(adolescent?.firstName + " " + adolescent?.name)
            binding.profielEmail.text = adolescent?.email
        })

        binding.wachtwoordWIjzigen.setOnClickListener(){

            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("Wachtwoord wijzigen")

            val viewInflated: View = LayoutInflater.from(context)
                .inflate(R.layout.profiel_changepassword, view as ViewGroup?, false)

            val inputOudww = viewInflated.findViewById<View>(R.id.oudwwfld) as EditText
            val inputNieuw = viewInflated.findViewById<View>(R.id.nieuwwwfld) as EditText
            val inputNieuwConfirm = viewInflated.findViewById<View>(R.id.nieuwwwfldconfirm) as EditText

            builder.setView(viewInflated)
            builder.setPositiveButton(android.R.string.ok,
                DialogInterface.OnClickListener { dialog, _ ->

                    nieuwww = inputNieuw.text.toString()
                    nieuwcon = inputNieuwConfirm.text.toString()
                    if(nieuwww.matches(Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{8,}$"))) {
                            if (nieuwww == nieuwcon) {

                                viewModel.changePassword(nieuwww)
                                dialog.dismiss()
                                Toast.makeText(
                                    this.context,
                                    "Nieuw wachtwoord ingesteld",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    this.context,
                                    "Beide wachtwoorden komen niet overeen",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else{
                        Toast.makeText(
                            this.context,
                            "wachtwoord moet 8 karakters, minstens 1 nummer, minstens 1 drukletter & kleineletter bevatten",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            builder.setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })

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
        }
    }
}
