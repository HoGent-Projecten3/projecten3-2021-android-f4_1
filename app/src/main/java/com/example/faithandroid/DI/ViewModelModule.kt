package com.example.faithandroid.DI

import com.example.faithandroid.PlaceType
import com.example.faithandroid.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostViewModel(PlaceType.Rugzak,get()) }
}
