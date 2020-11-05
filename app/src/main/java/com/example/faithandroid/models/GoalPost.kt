package com.example.faithandroid.models

class GoalPost{

    var title: String = ""
    var description: String = ""
    var completed: Boolean = false
    var steps: List<String> = listOf()

    constructor(title: String, text: String, completed:Boolean, steps:List<String>)
    {
        this.description = text
        this.title = title
        this.completed = completed
        this.steps = steps
    }
}