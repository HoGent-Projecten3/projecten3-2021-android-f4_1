package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
<<<<<<< HEAD
=======
import com.example.faithandroid.models.Post
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
<<<<<<< HEAD
import org.koin.test.KoinTest

@ExperimentalCoroutinesApi
class BillboardViewModelTest : KoinTest {
=======
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

@ExperimentalCoroutinesApi
class BillboardViewModelTest: KoinTest {
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3

    @get:Rule
    public val coroutineTestScope = CoroutineTestRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

<<<<<<< HEAD
    @Before
    fun before() {
    }

    @After
    fun after() {
    }

    @Test
    fun `get billboard goals shows billboardgoals`() {
    }
}
=======

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
    fun `get billboard goals shows billboardgoals`()
    {

    }

}
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
