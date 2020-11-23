package com.example.faithandroid;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class OptionsAddPostFragmentDirections {
  private OptionsAddPostFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionOptionsAddPostFragmentToBulletinBoardFragment() {
    return new ActionOnlyNavDirections(R.id.action_optionsAddPostFragment_to_bulletinBoardFragment);
  }
}
