package com.example.faithandroid.models

import org.threeten.bp.LocalDateTime


data class GoalPost(

    var title: String = "",
    var description: String = "",
    var completed: Boolean = false,
    var steps: List<Step> = listOf(),
    var date: String
)
