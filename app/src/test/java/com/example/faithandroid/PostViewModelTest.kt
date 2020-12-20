package com.example.faithandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
<<<<<<< HEAD
import androidx.lifecycle.MutableLiveData
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostRepository
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.util.Resource
import com.example.faithandroid.util.Status
=======
import com.example.faithandroid.models.Post
import com.example.faithandroid.post.PostViewModel
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
<<<<<<< HEAD
import org.junit.jupiter.params.provider.EnumSource
=======
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
<<<<<<< HEAD
import org.mockito.Mockito
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class PostViewModelTest : KoinTest {
=======

@ExperimentalCoroutinesApi
class PostViewModelTest: KoinTest {
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3

    @get:Rule
    public val coroutineTestScope = CoroutineTestRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

<<<<<<< HEAD
    private lateinit var postRepo: PostRepository
    private var list = MutableLiveData<Resource<List<Post>>>()

    @Before
    fun before() {
        startKoin {
            modules(
                module {
                    single<Post> { Post(1, "testTitel", "testTekst", "2019-11-05T22:34:57.61", PostType.Text.ordinal, "", "", true, true, true) }
                }
            )
        }

        postRepo = mock(PostRepository::class.java)

        list.postValue(
            Resource(
                Status.SUCCESS,
                listOf<Post>(
                    Post(
                        1,
                        "testTitel",
                        "testTekst",
                        "2019-11-05T22:34:57.61",
                        PostType.Text.ordinal,
                        "", "",
                        true,
                        true,
                        true
                    )
                ),
                ""
            )
        )
    }

    @After
    fun after() {
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
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3

        stopKoin()
    }

    @Test
<<<<<<< HEAD
    fun `getPostsOfPlace gets posts`() {

        Mockito.`when`(postRepo.getPostsOfPlaceByAdolescentEmail(PlaceType.Rugzak.ordinal)).thenReturn(list)
        val viewModel = PostViewModel(placeType = PlaceType.Rugzak, postRepo)
        viewModel.postList.observeForever {}
        assert(viewModel.postList.value?.data?.size == 1)
    }

    @ParameterizedTest
    @EnumSource(value = PostType::class, names = [], mode = EnumSource.Mode.EXCLUDE)
    fun `getFilteredPostsOfPlace gets different results for each postType`(postType: PostType) {
        val viewModel = PostViewModel(placeType = PlaceType.Rugzak, postRepo)
        viewModel.postList.observeForever {}
        viewModel.getFilteredPostFromPlace(PlaceType.Rugzak, postType)
        // assert(viewModel.postList.value!!.size == 1)
    }
}
=======
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
>>>>>>> c6afd76110f5c37a45a5483459d72529cf0e04d3
