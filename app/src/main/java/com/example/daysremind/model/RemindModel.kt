package com.example.daysremind.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Keep
@Entity(tableName = "remind_data")
data class RemindModel (
    @PrimaryKey(autoGenerate = true)
    var id :Int?=null,

    @SerializedName("label")
    var label: String?=null,

    @SerializedName("date_of_creation")
    var date_of_creation: String?=null,

    @SerializedName("target_date")
    var target_date: String?=null,

    @SerializedName("desc")
    var desc: String?=null
)
