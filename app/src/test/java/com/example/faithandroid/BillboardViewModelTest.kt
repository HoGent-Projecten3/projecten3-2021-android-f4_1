package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
class BillboardViewModelTest : KoinTest {

    @get:Rule
    public val coroutineTestScope = CoroutineTestRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun before() {
        startKoin {
            modules(
                module {
                }
            )
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `get billboard goals shows billboardgoals`() {
    }
}
