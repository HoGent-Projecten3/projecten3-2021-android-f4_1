package com.example.faithandroid;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToBackpackFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_backpackFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToBillboardFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_billboardFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToBulletinBoardFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_bulletinBoardFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToCinemaFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_cinemaFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToMusicRoomFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_musicRoomFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToShoppingCenterFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_shoppingCenterFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToSkyscraperFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_skyscraperFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToTreasureChestFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_treasureChestFragment);
  }
}
