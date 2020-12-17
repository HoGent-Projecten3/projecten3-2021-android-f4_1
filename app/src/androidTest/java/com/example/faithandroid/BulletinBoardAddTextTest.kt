package com.example.faithandroid


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
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
class BulletinBoardAddTextTest {

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
    fun bulletinBoardAddTextTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.login_button), withText("Log in"),
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
                withId(R.id.TekstButton), withText("Tekst"),
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

        val materialButton3 = onView(
            allOf(
                withId(R.id.textToevoegenButton), withText("nieuwe post toevoegen"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.FrameLayout")),
                        1
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val floatingActionButton2 = onView(
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
        floatingActionButton2.perform(click())

        val materialButton4 = onView(
            allOf(
                withId(R.id.TekstButton), withText("Tekst"),
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
        materialButton4.perform(click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.imageView4),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout2),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.textposttitel),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.textfield.TextInputLayout")),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(scrollTo(), replaceText("test"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.textposttext),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("com.google.android.material.textfield.TextInputLayout")),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(scrollTo(), replaceText("test"), closeSoftKeyboard())

        val materialButton5 = onView(
            allOf(
                withId(R.id.text_post_toevoegen), withText("Toevoegen"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton5.perform(scrollTo(), click())

        val materialCardView = onView(
            allOf(
                withId(R.id.card),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.BulletinBoardRecycler),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialCardView.perform(click())
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
