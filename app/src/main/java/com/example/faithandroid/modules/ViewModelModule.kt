package com.example.faithandroid.modules

import com.example.faithandroid.PlaceType
import com.example.faithandroid.billboard.BillboardViewModel
import com.example.faithandroid.login.uilogin.LoginViewModel
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.skyscraper.SkyscraperViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //viewModel { PostViewModel(PlaceType.Rugzak,get()) }
    viewModel { SkyscraperViewModel(get()) }
    viewModel { BillboardViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}
