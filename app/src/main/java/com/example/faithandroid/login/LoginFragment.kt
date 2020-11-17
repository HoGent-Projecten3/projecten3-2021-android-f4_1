package com.example.faithandroid.login


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.faithandroid.DrawerInterface
import com.example.faithandroid.MainActivity
import com.example.faithandroid.R
import com.example.faithandroid.databinding.LoginBinding
import com.example.faithandroid.login.uilogin.LoginActivity
import com.example.faithandroid.login.uilogin.LoginViewModel
import kotlinx.android.synthetic.main.login.*


class LoginFragment : Fragment() {

    private lateinit var drawer: DrawerLayout
    private lateinit var drawerInterface : DrawerInterface
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       //val intent =  Intent(LoginActivity.this)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            drawerInterface = activity as DrawerInterface
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement MyInterface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        drawerInterface.lockDrawer()
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<LoginBinding>(
            inflater,
            R.layout.login,
            container,
            false
        );


     //   viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


       binding.loginButton.setOnClickListener { view: View ->
            Log.i("zzzz", "DIT word gedaan")
            view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

        }
        // drawer = requireView().findViewById(R.id.drawerLayout)

        // drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        drawerInterface.unlockDrawer()
    }

}