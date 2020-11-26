package com.example.faithandroid.models

import org.threeten.bp.LocalDateTime

class TextPost {

    public var title: String = ""
    public var text: String = ""
    public var date: LocalDateTime = LocalDateTime.of(2020, 12, 10, 2, 12, 3)
    public val postType: Int = 0

    constructor(title: String, text: String)
    {
        this.text = text
        this.title = title
    }





}