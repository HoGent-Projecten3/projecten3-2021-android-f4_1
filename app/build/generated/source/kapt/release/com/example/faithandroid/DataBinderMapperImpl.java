package com.example.faithandroid;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.faithandroid.databinding.ActivityTestBindingImpl;
import com.example.faithandroid.databinding.AppHomeschermBindingImpl;
import com.example.faithandroid.databinding.BackpackBindingImpl;
import com.example.faithandroid.databinding.BillboardBindingImpl;
import com.example.faithandroid.databinding.BillboardGoalBindingImpl;
import com.example.faithandroid.databinding.BulletinboardBindingImpl;
import com.example.faithandroid.databinding.BulletinboardOptionsAddPostBindingImpl;
import com.example.faithandroid.databinding.BulletinboardTextPostToevoegenBindingImpl;
import com.example.faithandroid.databinding.BulletinboardTextpostBindingImpl;
import com.example.faithandroid.databinding.CinemaBindingImpl;
import com.example.faithandroid.databinding.LoginBindingImpl;
import com.example.faithandroid.databinding.MusicroomBindingImpl;
import com.example.faithandroid.databinding.ShoppingcenterBindingImpl;
import com.example.faithandroid.databinding.SkyscraperAddGoalBindingImpl;
import com.example.faithandroid.databinding.SkyscraperBindingImpl;
import com.example.faithandroid.databinding.SkyscraperGoaldetailsBindingImpl;
import com.example.faithandroid.databinding.TreasurechestBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYTEST = 1;

  private static final int LAYOUT_APPHOMESCHERM = 2;

  private static final int LAYOUT_BACKPACK = 3;

  private static final int LAYOUT_BILLBOARD = 4;

  private static final int LAYOUT_BILLBOARDGOAL = 5;

  private static final int LAYOUT_BULLETINBOARD = 6;

  private static final int LAYOUT_BULLETINBOARDOPTIONSADDPOST = 7;

  private static final int LAYOUT_BULLETINBOARDTEXTPOSTTOEVOEGEN = 8;

  private static final int LAYOUT_BULLETINBOARDTEXTPOST = 9;

  private static final int LAYOUT_CINEMA = 10;

  private static final int LAYOUT_LOGIN = 11;

  private static final int LAYOUT_MUSICROOM = 12;

  private static final int LAYOUT_SHOPPINGCENTER = 13;

  private static final int LAYOUT_SKYSCRAPER = 14;

  private static final int LAYOUT_SKYSCRAPERADDGOAL = 15;

  private static final int LAYOUT_SKYSCRAPERGOALDETAILS = 16;

  private static final int LAYOUT_TREASURECHEST = 17;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(17);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.activity_test, LAYOUT_ACTIVITYTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.app_homescherm, LAYOUT_APPHOMESCHERM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.backpack, LAYOUT_BACKPACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.billboard, LAYOUT_BILLBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.billboard_goal, LAYOUT_BILLBOARDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard, LAYOUT_BULLETINBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_options_add_post, LAYOUT_BULLETINBOARDOPTIONSADDPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_text_post_toevoegen, LAYOUT_BULLETINBOARDTEXTPOSTTOEVOEGEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_textpost, LAYOUT_BULLETINBOARDTEXTPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.cinema, LAYOUT_CINEMA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.login, LAYOUT_LOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.musicroom, LAYOUT_MUSICROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.shoppingcenter, LAYOUT_SHOPPINGCENTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper, LAYOUT_SKYSCRAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper_add_goal, LAYOUT_SKYSCRAPERADDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper_goaldetails, LAYOUT_SKYSCRAPERGOALDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.treasurechest, LAYOUT_TREASURECHEST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYTEST: {
          if ("layout/activity_test_0".equals(tag)) {
            return new ActivityTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_test is invalid. Received: " + tag);
        }
        case  LAYOUT_APPHOMESCHERM: {
          if ("layout/app_homescherm_0".equals(tag)) {
            return new AppHomeschermBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for app_homescherm is invalid. Received: " + tag);
        }
        case  LAYOUT_BACKPACK: {
          if ("layout/backpack_0".equals(tag)) {
            return new BackpackBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for backpack is invalid. Received: " + tag);
        }
        case  LAYOUT_BILLBOARD: {
          if ("layout/billboard_0".equals(tag)) {
            return new BillboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for billboard is invalid. Received: " + tag);
        }
        case  LAYOUT_BILLBOARDGOAL: {
          if ("layout/billboard_goal_0".equals(tag)) {
            return new BillboardGoalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for billboard_goal is invalid. Received: " + tag);
        }
        case  LAYOUT_BULLETINBOARD: {
          if ("layout/bulletinboard_0".equals(tag)) {
            return new BulletinboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bulletinboard is invalid. Received: " + tag);
        }
        case  LAYOUT_BULLETINBOARDOPTIONSADDPOST: {
          if ("layout/bulletinboard_options_add_post_0".equals(tag)) {
            return new BulletinboardOptionsAddPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bulletinboard_options_add_post is invalid. Received: " + tag);
        }
        case  LAYOUT_BULLETINBOARDTEXTPOSTTOEVOEGEN: {
          if ("layout/bulletinboard_text_post_toevoegen_0".equals(tag)) {
            return new BulletinboardTextPostToevoegenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bulletinboard_text_post_toevoegen is invalid. Received: " + tag);
        }
        case  LAYOUT_BULLETINBOARDTEXTPOST: {
          if ("layout/bulletinboard_textpost_0".equals(tag)) {
            return new BulletinboardTextpostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bulletinboard_textpost is invalid. Received: " + tag);
        }
        case  LAYOUT_CINEMA: {
          if ("layout/cinema_0".equals(tag)) {
            return new CinemaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for cinema is invalid. Received: " + tag);
        }
        case  LAYOUT_LOGIN: {
          if ("layout/login_0".equals(tag)) {
            return new LoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for login is invalid. Received: " + tag);
        }
        case  LAYOUT_MUSICROOM: {
          if ("layout/musicroom_0".equals(tag)) {
            return new MusicroomBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for musicroom is invalid. Received: " + tag);
        }
        case  LAYOUT_SHOPPINGCENTER: {
          if ("layout/shoppingcenter_0".equals(tag)) {
            return new ShoppingcenterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for shoppingcenter is invalid. Received: " + tag);
        }
        case  LAYOUT_SKYSCRAPER: {
          if ("layout/skyscraper_0".equals(tag)) {
            return new SkyscraperBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for skyscraper is invalid. Received: " + tag);
        }
        case  LAYOUT_SKYSCRAPERADDGOAL: {
          if ("layout/skyscraper_add_goal_0".equals(tag)) {
            return new SkyscraperAddGoalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for skyscraper_add_goal is invalid. Received: " + tag);
        }
        case  LAYOUT_SKYSCRAPERGOALDETAILS: {
          if ("layout/skyscraper_goaldetails_0".equals(tag)) {
            return new SkyscraperGoaldetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for skyscraper_goaldetails is invalid. Received: " + tag);
        }
        case  LAYOUT_TREASURECHEST: {
          if ("layout/treasurechest_0".equals(tag)) {
            return new TreasurechestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for treasurechest is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "date");
      sKeys.put(2, "goalDetailViewModel");
      sKeys.put(3, "placeType");
      sKeys.put(4, "post");
      sKeys.put(5, "property");
      sKeys.put(6, "viewModel");
      sKeys.put(7, "viewmodelBillboard");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(17);

    static {
      sKeys.put("layout/activity_test_0", com.example.faithandroid.R.layout.activity_test);
      sKeys.put("layout/app_homescherm_0", com.example.faithandroid.R.layout.app_homescherm);
      sKeys.put("layout/backpack_0", com.example.faithandroid.R.layout.backpack);
      sKeys.put("layout/billboard_0", com.example.faithandroid.R.layout.billboard);
      sKeys.put("layout/billboard_goal_0", com.example.faithandroid.R.layout.billboard_goal);
      sKeys.put("layout/bulletinboard_0", com.example.faithandroid.R.layout.bulletinboard);
      sKeys.put("layout/bulletinboard_options_add_post_0", com.example.faithandroid.R.layout.bulletinboard_options_add_post);
      sKeys.put("layout/bulletinboard_text_post_toevoegen_0", com.example.faithandroid.R.layout.bulletinboard_text_post_toevoegen);
      sKeys.put("layout/bulletinboard_textpost_0", com.example.faithandroid.R.layout.bulletinboard_textpost);
      sKeys.put("layout/cinema_0", com.example.faithandroid.R.layout.cinema);
      sKeys.put("layout/login_0", com.example.faithandroid.R.layout.login);
      sKeys.put("layout/musicroom_0", com.example.faithandroid.R.layout.musicroom);
      sKeys.put("layout/shoppingcenter_0", com.example.faithandroid.R.layout.shoppingcenter);
      sKeys.put("layout/skyscraper_0", com.example.faithandroid.R.layout.skyscraper);
      sKeys.put("layout/skyscraper_add_goal_0", com.example.faithandroid.R.layout.skyscraper_add_goal);
      sKeys.put("layout/skyscraper_goaldetails_0", com.example.faithandroid.R.layout.skyscraper_goaldetails);
      sKeys.put("layout/treasurechest_0", com.example.faithandroid.R.layout.treasurechest);
    }
  }
}
