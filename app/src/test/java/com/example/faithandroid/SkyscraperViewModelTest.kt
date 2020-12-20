package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest

@ExperimentalCoroutinesApi
class SkyscraperViewModelTest : KoinTest {

    @get:Rule
    public val coroutineTestScope = CoroutineTestRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun before() {
    }

    @After
    fun after() {
    }

    @Test
    fun `getGoals gets goals`() {

        // val viewModel = SkyscraperViewModel()
        // viewModel.testLive.observeForever{}
        // TODO mock
        // assert(viewModel.testLive.value?.size != 0)
    }

    @Test
    fun `getGoals gets errorMessage, errorMessage gets shown`() {
        // val viewModel = SkyscraperViewModel()
        // viewModel.testLive.observeForever{}
        // TODO mock + getposts

        // assert(viewModel.getStatus.value == "")
    }

    @Test
    fun `complete goal completes the goal`() {
        // val viewModel = SkyscraperViewModel()
        // viewModel.testLive.observeForever{}
        // TODO mock
        // assert(viewModel.testLive.value?.get(0)?.completed == true)
    }
}
