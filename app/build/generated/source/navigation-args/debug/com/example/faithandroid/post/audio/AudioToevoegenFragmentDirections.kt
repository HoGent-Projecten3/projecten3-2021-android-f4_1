package com.example.faithandroid.post.audio

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.faithandroid.R

class AudioToevoegenFragmentDirections private constructor() {
  companion object {
    fun actionAudioToevoegenFragmentToBulletinBoardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_audioToevoegenFragment_to_bulletinBoardFragment)

    fun actionAudioToevoegenFragmentToBackpackFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_audioToevoegenFragment_to_backpackFragment)

    fun actionAudioToevoegenFragmentToTreasureChestFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_audioToevoegenFragment_to_treasureChestFragment)
  }
}
