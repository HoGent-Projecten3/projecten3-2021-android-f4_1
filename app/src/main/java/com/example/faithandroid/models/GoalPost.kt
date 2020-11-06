package com.example.faithandroid.models



data class GoalPost(
    var id: Int,
    var title: String = "",
    var description: String = "",
    var completed: Boolean = false,
    var steps: List<Step> = listOf(),
    var date: String
)
