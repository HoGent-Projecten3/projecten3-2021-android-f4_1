package com.example.faithandroid;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.faithandroid.databinding.ActivityTestBindingImpl;
import com.example.faithandroid.databinding.AddPhotoBindingImpl;
import com.example.faithandroid.databinding.AddTextBindingImpl;
import com.example.faithandroid.databinding.AppHomeschermBindingImpl;
import com.example.faithandroid.databinding.AppNavHeaderMainBindingImpl;
import com.example.faithandroid.databinding.AudioToevoegenBindingImpl;
import com.example.faithandroid.databinding.BackpackBindingImpl;
import com.example.faithandroid.databinding.BackpackPostBindingImpl;
import com.example.faithandroid.databinding.BillboardBindingImpl;
import com.example.faithandroid.databinding.BillboardGoalBindingImpl;
import com.example.faithandroid.databinding.BulletinboardBindingImpl;
import com.example.faithandroid.databinding.BulletinboardOptionsAddPostBindingImpl;
import com.example.faithandroid.databinding.BulletinboardTextPostToevoegenBindingImpl;
import com.example.faithandroid.databinding.BulletinboardTextpostBindingImpl;
import com.example.faithandroid.databinding.CinemaBindingImpl;
import com.example.faithandroid.databinding.ExoplayerBindingImpl;
import com.example.faithandroid.databinding.FilteredPostBindingImpl;
import com.example.faithandroid.databinding.FullscreenImageBindingImpl;
import com.example.faithandroid.databinding.LoginBindingImpl;
import com.example.faithandroid.databinding.MusicroomBindingImpl;
import com.example.faithandroid.databinding.PostBindingImpl;
import com.example.faithandroid.databinding.ProfielBindingImpl;
import com.example.faithandroid.databinding.ProfielChangepasswordBindingImpl;
import com.example.faithandroid.databinding.ShoppingcenterBindingImpl;
import com.example.faithandroid.databinding.SkyscraperAddGoalBindingImpl;
import com.example.faithandroid.databinding.SkyscraperBindingImpl;
import com.example.faithandroid.databinding.SkyscraperGoaldetailsBindingImpl;
import com.example.faithandroid.databinding.TreasurechestBindingImpl;
import com.example.faithandroid.databinding.VideoNieuweVideoPostBindingImpl;
import com.example.faithandroid.databinding.VideoToevoegenBindingImpl;
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

  private static final int LAYOUT_ADDPHOTO = 2;

  private static final int LAYOUT_ADDTEXT = 3;

  private static final int LAYOUT_APPHOMESCHERM = 4;

  private static final int LAYOUT_APPNAVHEADERMAIN = 5;

  private static final int LAYOUT_AUDIOTOEVOEGEN = 6;

  private static final int LAYOUT_BACKPACK = 7;

  private static final int LAYOUT_BACKPACKPOST = 8;

  private static final int LAYOUT_BILLBOARD = 9;

  private static final int LAYOUT_BILLBOARDGOAL = 10;

  private static final int LAYOUT_BULLETINBOARD = 11;

  private static final int LAYOUT_BULLETINBOARDOPTIONSADDPOST = 12;

  private static final int LAYOUT_BULLETINBOARDTEXTPOSTTOEVOEGEN = 13;

  private static final int LAYOUT_BULLETINBOARDTEXTPOST = 14;

  private static final int LAYOUT_CINEMA = 15;

  private static final int LAYOUT_EXOPLAYER = 16;

  private static final int LAYOUT_FILTEREDPOST = 17;

  private static final int LAYOUT_FULLSCREENIMAGE = 18;

  private static final int LAYOUT_LOGIN = 19;

  private static final int LAYOUT_MUSICROOM = 20;

  private static final int LAYOUT_POST = 21;

  private static final int LAYOUT_PROFIEL = 22;

  private static final int LAYOUT_PROFIELCHANGEPASSWORD = 23;

  private static final int LAYOUT_SHOPPINGCENTER = 24;

  private static final int LAYOUT_SKYSCRAPER = 25;

  private static final int LAYOUT_SKYSCRAPERADDGOAL = 26;

  private static final int LAYOUT_SKYSCRAPERGOALDETAILS = 27;

  private static final int LAYOUT_TREASURECHEST = 28;

  private static final int LAYOUT_VIDEONIEUWEVIDEOPOST = 29;

  private static final int LAYOUT_VIDEOTOEVOEGEN = 30;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(30);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.activity_test, LAYOUT_ACTIVITYTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.add_photo, LAYOUT_ADDPHOTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.add_text, LAYOUT_ADDTEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.app_homescherm, LAYOUT_APPHOMESCHERM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.app_nav_header_main, LAYOUT_APPNAVHEADERMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.audio_toevoegen, LAYOUT_AUDIOTOEVOEGEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.backpack, LAYOUT_BACKPACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.backpack_post, LAYOUT_BACKPACKPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.billboard, LAYOUT_BILLBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.billboard_goal, LAYOUT_BILLBOARDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard, LAYOUT_BULLETINBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_options_add_post, LAYOUT_BULLETINBOARDOPTIONSADDPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_text_post_toevoegen, LAYOUT_BULLETINBOARDTEXTPOSTTOEVOEGEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.bulletinboard_textpost, LAYOUT_BULLETINBOARDTEXTPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.cinema, LAYOUT_CINEMA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.exoplayer, LAYOUT_EXOPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.filtered_post, LAYOUT_FILTEREDPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.fullscreen_image, LAYOUT_FULLSCREENIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.login, LAYOUT_LOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.musicroom, LAYOUT_MUSICROOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.post, LAYOUT_POST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.profiel, LAYOUT_PROFIEL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.profiel_changepassword, LAYOUT_PROFIELCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.shoppingcenter, LAYOUT_SHOPPINGCENTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper, LAYOUT_SKYSCRAPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper_add_goal, LAYOUT_SKYSCRAPERADDGOAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.skyscraper_goaldetails, LAYOUT_SKYSCRAPERGOALDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.treasurechest, LAYOUT_TREASURECHEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.video_nieuwe_video_post, LAYOUT_VIDEONIEUWEVIDEOPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.faithandroid.R.layout.video_toevoegen, LAYOUT_VIDEOTOEVOEGEN);
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
        case  LAYOUT_ADDPHOTO: {
          if ("layout/add_photo_0".equals(tag)) {
            return new AddPhotoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_photo is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDTEXT: {
          if ("layout/add_text_0".equals(tag)) {
            return new AddTextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_text is invalid. Received: " + tag);
        }
        case  LAYOUT_APPHOMESCHERM: {
          if ("layout/app_homescherm_0".equals(tag)) {
            return new AppHomeschermBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for app_homescherm is invalid. Received: " + tag);
        }
        case  LAYOUT_APPNAVHEADERMAIN: {
          if ("layout/app_nav_header_main_0".equals(tag)) {
            return new AppNavHeaderMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for app_nav_header_main is invalid. Received: " + tag);
        }
        case  LAYOUT_AUDIOTOEVOEGEN: {
          if ("layout/audio_toevoegen_0".equals(tag)) {
            return new AudioToevoegenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for audio_toevoegen is invalid. Received: " + tag);
        }
        case  LAYOUT_BACKPACK: {
          if ("layout/backpack_0".equals(tag)) {
            return new BackpackBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for backpack is invalid. Received: " + tag);
        }
        case  LAYOUT_BACKPACKPOST: {
          if ("layout/backpack_post_0".equals(tag)) {
            return new BackpackPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for backpack_post is invalid. Received: " + tag);
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
        case  LAYOUT_EXOPLAYER: {
          if ("layout/exoplayer_0".equals(tag)) {
            return new ExoplayerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for exoplayer is invalid. Received: " + tag);
        }
        case  LAYOUT_FILTEREDPOST: {
          if ("layout/filtered_post_0".equals(tag)) {
            return new FilteredPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for filtered_post is invalid. Received: " + tag);
        }
        case  LAYOUT_FULLSCREENIMAGE: {
          if ("layout/fullscreen_image_0".equals(tag)) {
            return new FullscreenImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fullscreen_image is invalid. Received: " + tag);
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
        case  LAYOUT_POST: {
          if ("layout/post_0".equals(tag)) {
            return new PostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for post is invalid. Received: " + tag);
        }
        case  LAYOUT_PROFIEL: {
          if ("layout/profiel_0".equals(tag)) {
            return new ProfielBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for profiel is invalid. Received: " + tag);
        }
        case  LAYOUT_PROFIELCHANGEPASSWORD: {
          if ("layout/profiel_changepassword_0".equals(tag)) {
            return new ProfielChangepasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for profiel_changepassword is invalid. Received: " + tag);
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
        case  LAYOUT_VIDEONIEUWEVIDEOPOST: {
          if ("layout/video_nieuwe_video_post_0".equals(tag)) {
            return new VideoNieuweVideoPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for video_nieuwe_video_post is invalid. Received: " + tag);
        }
        case  LAYOUT_VIDEOTOEVOEGEN: {
          if ("layout/video_toevoegen_0".equals(tag)) {
            return new VideoToevoegenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for video_toevoegen is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(13);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "adolescent");
      sKeys.put(2, "audioGekozen");
      sKeys.put(3, "date");
      sKeys.put(4, "goalDetailViewModel");
      sKeys.put(5, "placeType");
      sKeys.put(6, "post");
      sKeys.put(7, "posttype");
      sKeys.put(8, "property");
      sKeys.put(9, "textChosen");
      sKeys.put(10, "videoGekozen");
      sKeys.put(11, "viewModel");
      sKeys.put(12, "viewmodelBillboard");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(30);

    static {
      sKeys.put("layout/activity_test_0", com.example.faithandroid.R.layout.activity_test);
      sKeys.put("layout/add_photo_0", com.example.faithandroid.R.layout.add_photo);
      sKeys.put("layout/add_text_0", com.example.faithandroid.R.layout.add_text);
      sKeys.put("layout/app_homescherm_0", com.example.faithandroid.R.layout.app_homescherm);
      sKeys.put("layout/app_nav_header_main_0", com.example.faithandroid.R.layout.app_nav_header_main);
      sKeys.put("layout/audio_toevoegen_0", com.example.faithandroid.R.layout.audio_toevoegen);
      sKeys.put("layout/backpack_0", com.example.faithandroid.R.layout.backpack);
      sKeys.put("layout/backpack_post_0", com.example.faithandroid.R.layout.backpack_post);
      sKeys.put("layout/billboard_0", com.example.faithandroid.R.layout.billboard);
      sKeys.put("layout/billboard_goal_0", com.example.faithandroid.R.layout.billboard_goal);
      sKeys.put("layout/bulletinboard_0", com.example.faithandroid.R.layout.bulletinboard);
      sKeys.put("layout/bulletinboard_options_add_post_0", com.example.faithandroid.R.layout.bulletinboard_options_add_post);
      sKeys.put("layout/bulletinboard_text_post_toevoegen_0", com.example.faithandroid.R.layout.bulletinboard_text_post_toevoegen);
      sKeys.put("layout/bulletinboard_textpost_0", com.example.faithandroid.R.layout.bulletinboard_textpost);
      sKeys.put("layout/cinema_0", com.example.faithandroid.R.layout.cinema);
      sKeys.put("layout/exoplayer_0", com.example.faithandroid.R.layout.exoplayer);
      sKeys.put("layout/filtered_post_0", com.example.faithandroid.R.layout.filtered_post);
      sKeys.put("layout/fullscreen_image_0", com.example.faithandroid.R.layout.fullscreen_image);
      sKeys.put("layout/login_0", com.example.faithandroid.R.layout.login);
      sKeys.put("layout/musicroom_0", com.example.faithandroid.R.layout.musicroom);
      sKeys.put("layout/post_0", com.example.faithandroid.R.layout.post);
      sKeys.put("layout/profiel_0", com.example.faithandroid.R.layout.profiel);
      sKeys.put("layout/profiel_changepassword_0", com.example.faithandroid.R.layout.profiel_changepassword);
      sKeys.put("layout/shoppingcenter_0", com.example.faithandroid.R.layout.shoppingcenter);
      sKeys.put("layout/skyscraper_0", com.example.faithandroid.R.layout.skyscraper);
      sKeys.put("layout/skyscraper_add_goal_0", com.example.faithandroid.R.layout.skyscraper_add_goal);
      sKeys.put("layout/skyscraper_goaldetails_0", com.example.faithandroid.R.layout.skyscraper_goaldetails);
      sKeys.put("layout/treasurechest_0", com.example.faithandroid.R.layout.treasurechest);
      sKeys.put("layout/video_nieuwe_video_post_0", com.example.faithandroid.R.layout.video_nieuwe_video_post);
      sKeys.put("layout/video_toevoegen_0", com.example.faithandroid.R.layout.video_toevoegen);
    }
  }
}
