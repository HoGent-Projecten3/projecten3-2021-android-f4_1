package com.example.faithandroid.DI

import com.example.faithandroid.AvatarViewModel
import com.example.faithandroid.PlaceType
import com.example.faithandroid.billboard.BillboardViewModel
import com.example.faithandroid.login.uilogin.LoginViewModel
import com.example.faithandroid.musicRoom.MusicRoomViewModel
import com.example.faithandroid.post.PostViewModel
import com.example.faithandroid.profiel.ProfielViewModel
import com.example.faithandroid.skyscraper.SkyscraperViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SkyscraperViewModel(get()) }
    viewModel { BillboardViewModel(get()) }
    viewModel { ProfielViewModel(get(),get()) }
    viewModel { MusicRoomViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { AvatarViewModel(get()) }


}
