package com.example.faithandroid.network.local

import androidx.room.TypeConverter
import com.example.faithandroid.models.GoalPostFields
import com.example.faithandroid.models.StepFields
import com.google.gson.Gson

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
}