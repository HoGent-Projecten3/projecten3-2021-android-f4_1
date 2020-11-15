package com.example.faithandroid.skyscraper

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.faithandroid.models.GoalPost
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class GoalDetailsFragmentArgs(
  val goal: GoalPost
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): GoalDetailsFragmentArgs {
      bundle.setClassLoader(GoalDetailsFragmentArgs::class.java.classLoader)
      val __goal : GoalPost?
      if (bundle.containsKey("goal")) {
        if (Parcelable::class.java.isAssignableFrom(GoalPost::class.java) ||
            Serializable::class.java.isAssignableFrom(GoalPost::class.java)) {
          __goal = bundle.get("goal") as GoalPost?
        } else {
          throw UnsupportedOperationException(GoalPost::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__goal == null) {
          throw IllegalArgumentException("Argument \"goal\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"goal\" is missing and does not have an android:defaultValue")
      }
      return GoalDetailsFragmentArgs(__goal)
    }
  }
}
