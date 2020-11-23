package com.example.faithandroid;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.faithandroid.databinding.ActivityTestBindingImpl;
import com.example.faithandroid.databinding.FragmentAddGoalBindingImpl;
import com.example.faithandroid.databinding.FragmentBackpackBindingImpl;
import com.example.faithandroid.databinding.FragmentBilboardGoalBindingImpl;
import com.example.faithandroid.databinding.FragmentBillboardBindingImpl;
import com.example.faithandroid.databinding.FragmentBlankBindingImpl;
import com.example.faithandroid.databinding.FragmentBulletinboardBindingImpl;
import com.example.faithandroid.databinding.FragmentCinemaBindingImpl;
import com.example.faithandroid.databinding.FragmentGoaldetailsBindingImpl;
import com.example.faithandroid.databinding.FragmentHomeBindingImpl;
import com.example.faithandroid.databinding.FragmentLoginBindingImpl;
import com.example.faithandroid.databinding.FragmentMusicroomBindingImpl;
import com.example.faithandroid.databinding.FragmentShoppingcenterBindingImpl;
import com.example.faithandroid.databinding.FragmentSkyscraperBindingImpl;
import com.example.faithandroid.databinding.FragmentTextPostToevoegenBindingImpl;
import com.example.faithandroid.databinding.FragmentTreasurechestBindingImpl;
import com.example.faithandroid.databinding.GewoonEenTestVoorDeBackendBindingImpl;
import com.example.faithandroid.databinding.GridViewItemBindingImpl;
import com.example.faithandroid.databinding.MenuHomeschermBindingImpl;
import com.example.faithandroid.databinding.OptionsAddPostBindingImpl;
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

  private static final int LAYOUT_FRAGMENTADDGOAL = 2;

  private static final int LAYOUT_FRAGMENTBACKPACK = 3;

  private static final int LAYOUT_FRAGMENTBILBOARDGOAL = 4;

  private static final int LAYOUT_FRAGMENTBILLBOARD = 5;

  private static final int LAYOUT_FRAGMENTBLANK = 6;

  private static final int LAYOUT_FRAGMENTBULLETINBOARD = 7;

  private static final int LAYOUT_FRAGMENTCINEMA = 8;

  private static final int LAYOUT_FRAGMENTGOALDETAILS = 9;

  private static final int LAYOUT_FRAGMENTHOME = 10;

  private static final int LAYOUT_FRAGMENTLOGIN = 11;

  private static final int LAYOUT_FRAGMENTMUSICROOM = 12;

  private static final int LAYOUT_FRAGMENTSHOPPINGCENTER = 13;

  private static final int LAYOUT_FRAGMENTSKYSCRAPER = 14;

  private static final int LAYOUT_FRAGMENTTEXTPOSTTOEVOEGEN = 15;

  private static final int LAYOUT_FRAGMENTTREASURECHEST = 16;

  private static final int LAYOUT_GEWOONEENTESTVOORDEBACKEND = 17;

  private static final int LAYOUT_GRIDVIEWITEM = 18;

  private static final int LAYOUT_MENUHOMESCHERM = 19;

  private static final int LAYOUT_OPTIONSADDPOST = 20;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(20);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.activity_test, LAYOUT_ACTIVITYTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_add_goal, LAYOUT_FRAGMENTADDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_backpack, LAYOUT_FRAGMENTBACKPACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_bilboard_goal, LAYOUT_FRAGMENTBILBOARDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_billboard, LAYOUT_FRAGMENTBILLBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_blank, LAYOUT_FRAGMENTBLANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_bulletinboard, LAYOUT_FRAGMENTBULLETINBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_cinema, LAYOUT_FRAGMENTCINEMA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_goaldetails, LAYOUT_FRAGMENTGOALDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_musicroom, LAYOUT_FRAGMENTMUSICROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_shoppingcenter, LAYOUT_FRAGMENTSHOPPINGCENTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_skyscraper, LAYOUT_FRAGMENTSKYSCRAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_text_post_toevoegen, LAYOUT_FRAGMENTTEXTPOSTTOEVOEGEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fragment_treasurechest, LAYOUT_FRAGMENTTREASURECHEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.gewoon_een_test_voor_de_backend, LAYOUT_GEWOONEENTESTVOORDEBACKEND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.grid_view_item, LAYOUT_GRIDVIEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.menu_homescherm, LAYOUT_MENUHOMESCHERM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.options_add_post, LAYOUT_OPTIONSADDPOST);
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
        case  LAYOUT_FRAGMENTADDGOAL: {
          if ("layout/fragment_add_goal_0".equals(tag)) {
            return new FragmentAddGoalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_add_goal is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBACKPACK: {
          if ("layout/fragment_backpack_0".equals(tag)) {
            return new FragmentBackpackBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_backpack is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBILBOARDGOAL: {
          if ("layout/fragment_bilboard_goal_0".equals(tag)) {
            return new FragmentBilboardGoalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_bilboard_goal is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBILLBOARD: {
          if ("layout/fragment_billboard_0".equals(tag)) {
            return new FragmentBillboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_billboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBLANK: {
          if ("layout/fragment_blank_0".equals(tag)) {
            return new FragmentBlankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_blank is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBULLETINBOARD: {
          if ("layout/fragment_bulletinboard_0".equals(tag)) {
            return new FragmentBulletinboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_bulletinboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCINEMA: {
          if ("layout/fragment_cinema_0".equals(tag)) {
            return new FragmentCinemaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cinema is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGOALDETAILS: {
          if ("layout/fragment_goaldetails_0".equals(tag)) {
            return new FragmentGoaldetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_goaldetails is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUSICROOM: {
          if ("layout/fragment_musicroom_0".equals(tag)) {
            return new FragmentMusicroomBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_musicroom is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHOPPINGCENTER: {
          if ("layout/fragment_shoppingcenter_0".equals(tag)) {
            return new FragmentShoppingcenterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shoppingcenter is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSKYSCRAPER: {
          if ("layout/fragment_skyscraper_0".equals(tag)) {
            return new FragmentSkyscraperBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_skyscraper is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTEXTPOSTTOEVOEGEN: {
          if ("layout/fragment_text_post_toevoegen_0".equals(tag)) {
            return new FragmentTextPostToevoegenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_text_post_toevoegen is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTREASURECHEST: {
          if ("layout/fragment_treasurechest_0".equals(tag)) {
            return new FragmentTreasurechestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_treasurechest is invalid. Received: " + tag);
        }
        case  LAYOUT_GEWOONEENTESTVOORDEBACKEND: {
          if ("layout/gewoon_een_test_voor_de_backend_0".equals(tag)) {
            return new GewoonEenTestVoorDeBackendBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for gewoon_een_test_voor_de_backend is invalid. Received: " + tag);
        }
        case  LAYOUT_GRIDVIEWITEM: {
          if ("layout/grid_view_item_0".equals(tag)) {
            return new GridViewItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for grid_view_item is invalid. Received: " + tag);
        }
        case  LAYOUT_MENUHOMESCHERM: {
          if ("layout/menu_homescherm_0".equals(tag)) {
            return new MenuHomeschermBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for menu_homescherm is invalid. Received: " + tag);
        }
        case  LAYOUT_OPTIONSADDPOST: {
          if ("layout/options_add_post_0".equals(tag)) {
            return new OptionsAddPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for options_add_post is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "property");
      sKeys.put(2, "viewModellalala");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(20);

    static {
      sKeys.put("layout/activity_test_0", com.example.faithandroid.R.layout.activity_test);
      sKeys.put("layout/fragment_add_goal_0", com.example.faithandroid.R.layout.fragment_add_goal);
      sKeys.put("layout/fragment_backpack_0", com.example.faithandroid.R.layout.fragment_backpack);
      sKeys.put("layout/fragment_bilboard_goal_0", com.example.faithandroid.R.layout.fragment_bilboard_goal);
      sKeys.put("layout/fragment_billboard_0", com.example.faithandroid.R.layout.fragment_billboard);
      sKeys.put("layout/fragment_blank_0", com.example.faithandroid.R.layout.fragment_blank);
      sKeys.put("layout/fragment_bulletinboard_0", com.example.faithandroid.R.layout.fragment_bulletinboard);
      sKeys.put("layout/fragment_cinema_0", com.example.faithandroid.R.layout.fragment_cinema);
      sKeys.put("layout/fragment_goaldetails_0", com.example.faithandroid.R.layout.fragment_goaldetails);
      sKeys.put("layout/fragment_home_0", com.example.faithandroid.R.layout.fragment_home);
      sKeys.put("layout/fragment_login_0", com.example.faithandroid.R.layout.fragment_login);
      sKeys.put("layout/fragment_musicroom_0", com.example.faithandroid.R.layout.fragment_musicroom);
      sKeys.put("layout/fragment_shoppingcenter_0", com.example.faithandroid.R.layout.fragment_shoppingcenter);
      sKeys.put("layout/fragment_skyscraper_0", com.example.faithandroid.R.layout.fragment_skyscraper);
      sKeys.put("layout/fragment_text_post_toevoegen_0", com.example.faithandroid.R.layout.fragment_text_post_toevoegen);
      sKeys.put("layout/fragment_treasurechest_0", com.example.faithandroid.R.layout.fragment_treasurechest);
      sKeys.put("layout/gewoon_een_test_voor_de_backend_0", com.example.faithandroid.R.layout.gewoon_een_test_voor_de_backend);
      sKeys.put("layout/grid_view_item_0", com.example.faithandroid.R.layout.grid_view_item);
      sKeys.put("layout/menu_homescherm_0", com.example.faithandroid.R.layout.menu_homescherm);
      sKeys.put("layout/options_add_post_0", com.example.faithandroid.R.layout.options_add_post);
    }
  }
}
