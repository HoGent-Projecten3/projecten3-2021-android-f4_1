package com.example.faithandroid.login


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.faithandroid.R
import com.example.faithandroid.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        );
        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)


        }
            return binding.root

        }

}