package com.example.faithandroid.login

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.faithandroid.R

class LoginFragmentDirections private constructor() {
  companion object {
    fun actionLoginFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_homeFragment)
  }
}
