package com.example.faithandroid.post.audio

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.faithandroid.PlaceType
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class AudioToevoegenFragmentArgs(
  val placeType: PlaceType
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): AudioToevoegenFragmentArgs {
      bundle.setClassLoader(AudioToevoegenFragmentArgs::class.java.classLoader)
      val __placeType : PlaceType?
      if (bundle.containsKey("placeType")) {
        if (Parcelable::class.java.isAssignableFrom(PlaceType::class.java) ||
            Serializable::class.java.isAssignableFrom(PlaceType::class.java)) {
          __placeType = bundle.get("placeType") as PlaceType?
        } else {
          throw UnsupportedOperationException(PlaceType::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__placeType == null) {
          throw IllegalArgumentException("Argument \"placeType\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"placeType\" is missing and does not have an android:defaultValue")
      }
      return AudioToevoegenFragmentArgs(__placeType)
    }
  }
}
