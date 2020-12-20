package com.example.faithandroid.models
/**
 * Class that supports the group an adolescent belongs to
 */
data class Group (
    /**
     * @param is the id of the group
     * @param adolescents is a list of adolescent that belong to this group
     */
    var id: Int = 0,
    var adolescents : List<Adolescent> = listOf()
)