package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

@ExperimentalCoroutinesApi
class PostViewModelTest: KoinTest {

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
    fun `getPostsOfPlace gets posts`()
    {

        val viewModel = PostViewModel(placeType = PlaceType.Rugzak)
        viewModel.postList.observeForever{}
        assert(viewModel.postList.value!!.size == 1)
    }

    @Test
    fun `getFilteredPostsOfPlace gets filtered posts`()
    {
        val viewModel = PostViewModel(placeType = PlaceType.Rugzak)
        viewModel.postList.observeForever{}
        viewModel.getFilteredPostFromPlace(PlaceType.Rugzak, PostType.Text)
        assert(viewModel.postList.value!!.size == 1)
    }

    @ParameterizedTest
    @EnumSource(value = PostType::class, names =[], mode = EnumSource.Mode.EXCLUDE)
    fun `getFilteredPostsOfPlace gets different results for each postType`(postType: PostType)
    {
        val viewModel = PostViewModel(placeType = PlaceType.Rugzak)
        viewModel.postList.observeForever{}
        viewModel.getFilteredPostFromPlace(PlaceType.Rugzak, postType)
        assert(viewModel.postList.value!!.size == 1)
    }

}