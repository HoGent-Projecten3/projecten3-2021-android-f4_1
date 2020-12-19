package com.example.faithandroid


import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.registerIdlingResources
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.example.faithandroid.login.uilogin.LoginActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception
import java.util.concurrent.TimeUnit


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant(
            "android.permission.RECORD_AUDIO",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
        )

    @Test
    fun loginActivityTest() {

        IdlingPolicies.setIdlingResourceTimeout(
            100 * 30, TimeUnit.MILLISECONDS
        );



        val materialButton = onView(
            allOf(
                withId(R.id.login_button),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val loginIdlingResource: IdlingResource = LoginIdlingResource()
        IdlingRegistry.getInstance().register(loginIdlingResource)

        val imageView = onView(
            withId(R.id.img_bulletinboard)
        ).check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}


class LoginIdlingResource : IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null
    private var isIdle = false
    override fun getName(): String {
        return LoginIdlingResource::class.java.name
    }

    override fun isIdleNow(): Boolean {

        Log.d("activityTest", AppPreferences.token.toString())
        if (AppPreferences.token == null)
        {
            Log.d("activityTest", "pls work")
            return false
        }
        return true
//        var imageView: ViewInteraction? = null
//        var viewFound: Boolean = false
//        try
//        {
//            imageView = onView(
//                allOf(
//                    withId(R.id.img_bulletinboard)
//                        )).check(matches(isDisplayed()))
//            viewFound = true
//        }
//        catch (e: NoMatchingViewException)
//        {
//            viewFound = false
//        }
//        finally {
//
//            if (!viewFound)
//            {
//                Log.d("activityTest", "NO ACTIVITY")
//                return false
//            }
//            else
//            {
//                Log.d("activityTest", "ACTIVITY")
//                isIdle = true
//            }
//
//            if (isIdle) {
//                resourceCallback!!.onTransitionToIdle()
//            }
//            return isIdle
//        }


    }
    override fun registerIdleTransitionCallback(
        resourceCallback: IdlingResource.ResourceCallback
    ) {
        this.resourceCallback = resourceCallback
    }
}
