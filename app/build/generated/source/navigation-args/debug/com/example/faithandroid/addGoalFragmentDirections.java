package com.example.faithandroid;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class addGoalFragmentDirections {
  private addGoalFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddGoalFragmentToSkyscraperFragment() {
    return new ActionOnlyNavDirections(R.id.action_addGoalFragment_to_skyscraperFragment);
  }
}
