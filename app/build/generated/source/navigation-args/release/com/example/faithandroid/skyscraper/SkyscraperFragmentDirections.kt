package com.example.faithandroid.skyscraper

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.faithandroid.R
import com.example.faithandroid.models.GoalPost
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class SkyscraperFragmentDirections private constructor() {
  private data class ActionSkyscraperFragmentToGoalDetailsFragment(
    val goal: GoalPost
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_skyscraperFragment_to_goalDetailsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(GoalPost::class.java)) {
        result.putParcelable("goal", this.goal as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(GoalPost::class.java)) {
        result.putSerializable("goal", this.goal as Serializable)
      } else {
        throw UnsupportedOperationException(GoalPost::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionSkyscraperFragmentToAddGoalFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_skyscraperFragment_to_addGoalFragment)

    fun actionSkyscraperFragmentToGoalDetailsFragment(goal: GoalPost): NavDirections =
        ActionSkyscraperFragmentToGoalDetailsFragment(goal)
  }
}
