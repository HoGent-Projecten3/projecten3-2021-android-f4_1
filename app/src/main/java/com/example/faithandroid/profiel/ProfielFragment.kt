package com.example.faithandroid.profiel

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.MainActivity
import com.example.faithandroid.R
import com.example.faithandroid.databinding.ProfielBinding
import com.example.faithandroid.models.ChangePassword
import com.example.faithandroid.skyscraper.SkyscraperViewModel


class ProfielFragment: Fragment() {

    private lateinit var viewModel: ProfielViewModel
    private var nieuwww = ""


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

        viewModel = ViewModelProvider(this).get(ProfielViewModel::class.java)

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
                        dialog.dismiss()
                        nieuwww = inputNieuw.text.toString()

                        var changep =  ChangePassword("","",nieuwww)
                        viewModel.changePassword(changep)
                })
            builder.setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })

            builder.show()
        }

        binding.donkereModus.setOnClickListener(){

            val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (isNightTheme) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
        return binding.root
    }
}