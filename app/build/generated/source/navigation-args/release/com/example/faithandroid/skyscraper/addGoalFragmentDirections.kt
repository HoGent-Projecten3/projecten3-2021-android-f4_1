package com.example.faithandroid.skyscraper

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.faithandroid.R

class addGoalFragmentDirections private constructor() {
  companion object {
    fun actionAddGoalFragmentToSkyscraperFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addGoalFragment_to_skyscraperFragment)
  }
}
