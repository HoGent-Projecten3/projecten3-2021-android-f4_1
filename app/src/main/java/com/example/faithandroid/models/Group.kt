package com.example.faithandroid.models

data class Group(
    var id: Int = 0,
    var adolescents: List<Adolescent> = listOf()
)
