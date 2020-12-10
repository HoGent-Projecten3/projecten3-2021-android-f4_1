package com.example.faithandroid.DI

<<<<<<< HEAD
import com.example.faithandroid.AvatarViewModel
=======
>>>>>>> 8b69d0a (repository spotify + posts niet af)
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
    viewModel { ProfielViewModel(get()) }
    viewModel { MusicRoomViewModel(get()) }
    viewModel { LoginViewModel(get()) }
<<<<<<< HEAD
    viewModel { AvatarViewModel(get()) }
=======
>>>>>>> 8b69d0a (repository spotify + posts niet af)

}
