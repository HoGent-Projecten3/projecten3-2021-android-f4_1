package com.example.faithandroid

import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.example.faithandroid.login.data.LoginRepository
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
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

    private lateinit var loginRepository: LoginRepository

    @Before
    fun before() {
        // loginRepository = mock(LoginRepository::class.java)
    }

    @Test
    fun loginActivityTest() {

        IdlingPolicies.setIdlingResourceTimeout(
            100 * 30,
            TimeUnit.MILLISECONDS
        )

        if (AppPreferences.token == null) {
            val materialButton = onView(
                allOf(
                    withId(R.id.login_button),
                    isDisplayed()
                )
            )
            materialButton.perform(click())

            val loginIdlingResource: IdlingResource = LoginIdlingResource()
            IdlingRegistry.getInstance().register(loginIdlingResource)
        }

        val imageView = onView(
            withId(R.id.img_bulletinboard)
        ).check(matches(isDisplayed()))
    }

    class LoginIdlingResource : IdlingResource {
        private var resourceCallback: IdlingResource.ResourceCallback? = null
        private var isIdle = false
        override fun getName(): String {
            return LoginIdlingResource::class.java.name
        }

        override fun isIdleNow(): Boolean {
            if (AppPreferences.token == null) {
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
}
