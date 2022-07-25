package com.example.daysremind.converter

import com.example.daysremind.model.RemindModel
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


/**
 * Created by 1000292 on 25-01-2021
 * BFDL (MFP)
 * PUNE.
 */

class RemindConverters {
    private val gson = Gson()

    @TypeConverter
    fun stringToRemindModel(data: String?): List<RemindModel?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<RemindModel?>?>() {}.type
        return gson.fromJson<List<RemindModel?>>(data, listType)
    }


}