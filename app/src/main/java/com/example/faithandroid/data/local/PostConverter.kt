package com.example.faithandroid.data.local

import androidx.room.TypeConverter
import com.example.faithandroid.models.PostFields
import com.google.gson.Gson

class PostConverter {
    @TypeConverter
    fun stringToFields(value: String): PostFields {
        return Gson().fromJson(value, PostFields::class.java)
    }

    @TypeConverter
    fun playersToString(fields: PostFields): String {
        return Gson().toJson(fields)
    }
}