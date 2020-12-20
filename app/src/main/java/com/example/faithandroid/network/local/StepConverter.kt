package com.example.faithandroid.network.local

import androidx.room.TypeConverter
import com.example.faithandroid.models.StepFields
import com.google.gson.Gson

class StepConverter {

    @TypeConverter
    fun stringToFields(value: String): StepFields {
        return Gson().fromJson(value, StepFields::class.java)
    }

    @TypeConverter
    fun playersToString(fields: StepFields): String {
        return Gson().toJson(fields)
    }
}