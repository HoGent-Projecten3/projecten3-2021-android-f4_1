package com.example.faithandroid.models
/**
 * Class that supports the group an adolescent belongs to
 *
 * @property id is the id of the group
 * @property adolescents is a list of adolescent that belong to this group
 */
data class Group(
    var id: Int = 0,
    var adolescents: List<Adolescent> = listOf()
)
