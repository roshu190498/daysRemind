package com.example.daysremind.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.room.*
import com.example.daysremind.converter.RemindConverters
import com.example.daysremind.dao.RemindDao
import com.example.daysremind.model.RemindModel


const val ROOM_VERSION = 1

@Database(
    entities = [
        RemindModel::class
    ],
    exportSchema = false,
    version = ROOM_VERSION
)
@TypeConverters( RemindConverters::class)
public abstract class RemindDatabase  : RoomDatabase() {
    abstract fun remindDao() : RemindDao
    companion object{
        @Volatile
        private var INSTANCE : RemindDatabase? = null

        fun getDatabase(context: Context): RemindDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RemindDatabase::class.java,
                    "remind_database"
                ).fallbackToDestructiveMigration().
                build()
                INSTANCE = instance
                instance
            }
        }
    }

}

