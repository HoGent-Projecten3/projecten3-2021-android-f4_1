package com.example.faithandroid;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class SkyscraperFragmentDirections {
  private SkyscraperFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSkyscraperFragmentToAddGoalFragment() {
    return new ActionOnlyNavDirections(R.id.action_skyscraperFragment_to_addGoalFragment);
  }

  @NonNull
  public static NavDirections actionSkyscraperFragmentToGoalDetailsFragment() {
    return new ActionOnlyNavDirections(R.id.action_skyscraperFragment_to_goalDetailsFragment);
  }
}
