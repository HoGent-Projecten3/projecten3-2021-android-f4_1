package com.example.faithandroid

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class BulletinBoardTest {

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
    fun addPostToBulletinBoardTest() {

        if (AppPreferences.token == null) {
            onView(
                withId(
                    R.id.txtemail
                )
            ).perform(replaceText("jan.coppens@gmail.com"))
            closeSoftKeyboard()

            onView(
                withId(
                    R.id.txtwachtwoord
                )
            ).perform(replaceText("W@chtwoord1Jan"))

            closeSoftKeyboard()

            val materialButton = onView(
                allOf(
                    withId(R.id.login_button),
                    withText("Log in"),
                    childAtPosition(
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        ),
                        2
                    ),
                    isDisplayed()
                )
            )
            materialButton.perform(click())

            Thread.sleep(4000)
        }

        val appCompatImageView = onView(
            allOf(
                withId(R.id.img_bulletinboard),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    0
                )
            )
        )
        appCompatImageView.perform(scrollTo(), click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.AddPostButton),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.NavHostFragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.TekstButton),
                withText("Tekst"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.TableLayout")),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val appCompatImageView2 = onView(
            withId(R.id.imageView4)
        )
        appCompatImageView2.perform(click())

        val textInputEditText = onView(
            withId(R.id.textposttitel)
        )
        textInputEditText.perform(scrollTo(), replaceText("testPost"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            withId(R.id.textposttext),
        )
        textInputEditText2.perform(scrollTo(), replaceText("test"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            withId(R.id.textposttext)
        )
        textInputEditText3.perform(scrollTo(), click())

        pressBack()

        val materialButton3 = onView(
            withId(R.id.text_post_toevoegen)
        )
        materialButton3.perform(scrollTo(), click())

        val post = onView(
            withText("testPost")
        )
        post.check(matches(isDisplayed()))

        val testPost = onView(
            withId(R.id.DeletePostButton),
        )

        testPost.perform(click())

        val confirmDelete = onView(
            allOf(
                withId(android.R.id.button1),
                withText("Ja"),

            )
        )
        confirmDelete.perform(scrollTo(), click())

        onView(
            withId(R.id.imageMenuBack)
        ).perform(click())

        onView(
            withId(R.id.img_bulletinboard)
        ).check(matches(isDisplayed()))

        onView(
            withId(R.id.img_rugzak)
        ).perform(scrollTo(), click())

        val rugzakPost = onView(
            withId(R.id.DeletePostButton),
        )

        rugzakPost.perform(click())

        val permanentlyDelete = onView(
            allOf(
                withId(android.R.id.button1),
                withText("Ja"),

            )
        )
        permanentlyDelete.perform(scrollTo(), click())
    }
    private fun childAtPosition(
        parentMatcher: Matcher<View>,
        position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent) &&
                    view == parent.getChildAt(position)
            }
        }
    }
}
