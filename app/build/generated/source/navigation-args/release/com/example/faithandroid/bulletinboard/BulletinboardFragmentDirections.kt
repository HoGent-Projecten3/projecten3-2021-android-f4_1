package com.example.faithandroid.bulletinboard

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.faithandroid.PlaceType
import com.example.faithandroid.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class BulletinboardFragmentDirections private constructor() {
  private data class ActionBulletinBoardFragmentToOptionsAddPostFragment(
    val placeType: PlaceType
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_bulletinBoardFragment_to_optionsAddPostFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(PlaceType::class.java)) {
        result.putParcelable("placeType", this.placeType as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(PlaceType::class.java)) {
        result.putSerializable("placeType", this.placeType as Serializable)
      } else {
        throw UnsupportedOperationException(PlaceType::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionBulletinBoardFragmentToOptionsAddPostFragment(placeType: PlaceType): NavDirections =
        ActionBulletinBoardFragmentToOptionsAddPostFragment(placeType)
  }
}
