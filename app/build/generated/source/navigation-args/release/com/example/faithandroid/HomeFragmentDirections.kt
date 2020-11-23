package com.example.faithandroid

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class HomeFragmentDirections private constructor() {
  companion object {
    fun actionHomeFragmentToBackpackFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_backpackFragment)

    fun actionHomeFragmentToBillboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_billboardFragment)

    fun actionHomeFragmentToBulletinBoardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_bulletinBoardFragment)

    fun actionHomeFragmentToCinemaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_cinemaFragment)

    fun actionHomeFragmentToMusicRoomFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_musicRoomFragment)

    fun actionHomeFragmentToShoppingCenterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_shoppingCenterFragment)

    fun actionHomeFragmentToSkyscraperFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_skyscraperFragment)

    fun actionHomeFragmentToTreasureChestFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_treasureChestFragment)
  }
}
