package com.example.faithandroid

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class addTextFragmentDirections private constructor() {
  private data class ActionAddTextFragmentToTextPostToevoegen(
    val placeType: PlaceType
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_addTextFragment_to_text_post_toevoegen

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
    fun actionAddTextFragmentToTextPostToevoegen(placeType: PlaceType): NavDirections =
        ActionAddTextFragmentToTextPostToevoegen(placeType)

    fun actionAddTextFragmentToBulletinBoardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addTextFragment_to_bulletinBoardFragment)

    fun actionAddTextFragmentToBackpackFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addTextFragment_to_backpackFragment)

    fun actionAddTextFragmentToTreasureChestFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addTextFragment_to_treasureChestFragment)
  }
}
