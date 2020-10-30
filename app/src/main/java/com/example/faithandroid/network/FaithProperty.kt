package com.example.faithandroid.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.faithandroid.R
import com.example.faithandroid.databinding.FragmentCinemaBinding
import com.example.faithandroid.viewmodels.CinemaViewModel
import java.time.LocalDate
import java.time.LocalDateTime


data class FaithProperty(
    val city: Integer,
    val avatar: Integer,
    val firstName: String,
    val name: String,
    val email: String,
    val wantsConsultation: Boolean,
    val dateOfBirth: LocalDateTime,
)