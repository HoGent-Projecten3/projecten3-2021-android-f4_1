package com.example.faithandroid.network.local

import androidx.room.TypeConverter
import com.example.faithandroid.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun goalStringToFields(value: String): GoalPostFields {
        return Gson().fromJson(value, GoalPostFields::class.java)
    }

    @TypeConverter
    fun goalPlayersToString(fields: GoalPostFields): String {
        return Gson().toJson(fields)
    }

    @TypeConverter
    fun stepStringToFields(value: String): StepFields {
        return Gson().fromJson(value, StepFields::class.java)
    }

    @TypeConverter
    fun stepPlayersToString(fields: StepFields): String {
        return Gson().toJson(fields)
    }

    @TypeConverter
    fun playListStringToFields(value: String): PlaylistFields {
        return Gson().fromJson(value, PlaylistFields::class.java)
    }

    @TypeConverter
    fun playListPlayersToString(fields: PlaylistFields): String {
        return Gson().toJson(fields)
    }

    @TypeConverter
    fun stringToFields(value: String): PostFields {
        return Gson().fromJson(value, PostFields::class.java)
    }

    @TypeConverter
    fun playersToString(fields: PostFields): String {
        return Gson().toJson(fields)
    }

    @TypeConverter
    fun listToJson(value: List<Step>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Step>::class.java).toList()

    @TypeConverter
    fun AvatarStringToFields(value: String): AvatarFields {
        return Gson().fromJson(value, AvatarFields::class.java)
    }

    @TypeConverter
    fun AvatarPlayersToString(fields: AvatarFields): String {
        return Gson().toJson(fields)
    }
}