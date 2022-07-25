package com.example.daysremind.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.daysremind.model.RemindModel

@Dao
@Entity
interface RemindDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemindModel(remindModel: RemindModel)



}