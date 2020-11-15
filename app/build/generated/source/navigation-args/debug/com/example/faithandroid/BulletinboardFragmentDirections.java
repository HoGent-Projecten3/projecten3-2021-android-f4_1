package com.example.faithandroid;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class BulletinboardFragmentDirections {
  private BulletinboardFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionBulletinBoardFragmentToOptionsAddPostFragment() {
    return new ActionOnlyNavDirections(R.id.action_bulletinBoardFragment_to_optionsAddPostFragment);
  }
}
