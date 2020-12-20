package com.example.faithandroid


import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.example.faithandroid.DI.viewModelModule
import com.example.faithandroid.login.data.LoginRepository
import com.example.faithandroid.login.uilogin.LoggedInUserView
import com.example.faithandroid.login.uilogin.LoginResult
import com.example.faithandroid.login.uilogin.LoginViewModel
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner



@LargeTest
@RunWith(MockitoJUnitRunner::class)
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

    lateinit var mockLoginViewModel: LoginViewModel
    lateinit var mockLoginRepository: LoginRepository

    @Before
    fun before()
    {
        mockLoginRepository = mock(LoginRepository::class.java)
        mockLoginViewModel = mock(LoginViewModel::class.java)


        loadKoinModules( module
        {
            viewModelModule
            {
                mockLoginViewModel
            }
        })

    }

    @After
    fun cleanUp() {
        stopKoin()
    }

    @Test
    fun bulletinBoardAddTextTest() {

        var loginResult = MutableLiveData<LoginResult>()
        loginResult.value = LoginResult(
            success = LoggedInUserView(
                token = "whatever",
                displayName = "test" + " " + "de bouwer",
                email = "bob.debouwer1998@gmail.com"
            )
        )

        Mockito.`when`(mockLoginViewModel.login("bob.debouwer1998@gmail.com", "KunnenWeHetMaken?1"))
        Mockito.`when`(mockLoginViewModel.loginResult).thenReturn(loginResult)
        val materialButton = onView(
            withId(R.id.login_button)
        )
        materialButton.perform(click())
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
