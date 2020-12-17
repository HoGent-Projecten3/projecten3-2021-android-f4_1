package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.skyscraper.SkyscraperViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest


@ExperimentalCoroutinesApi
class SkyscraperViewModelTest: KoinTest {

    @get:Rule
    public val coroutineTestScope = CoroutineTestRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()


    @Before
    fun before()
    {
        startKoin {
            modules(module {
                single<Post> { Post(1, "testTitel", "testTekst", "2019-11-05T22:34:57.61", PostType.Text.ordinal, "", "" ) }
            })
        }


    }

    @After
    fun after()
    {
        stopKoin()
    }

    @Test
    fun `getGoals gets goals`()
    {

        val viewModel = SkyscraperViewModel()
        viewModel.testLive.observeForever{}
        //TODO mock
        assert(viewModel.testLive.value?.size != 0)
    }

    @Test
    fun `getGoals gets errorMessage, errorMessage gets shown`()
    {
        val viewModel = SkyscraperViewModel()
        viewModel.testLive.observeForever{}
        //TODO mock + getposts

        assert(viewModel.getStatus.value == "")
    }

    @Test
    fun `complete goal completes the goal`()
    {
        val viewModel = SkyscraperViewModel()
        viewModel.testLive.observeForever{}
        //TODO mock
        assert(viewModel.testLive.value?.get(0)?.completed == true)
    }

}