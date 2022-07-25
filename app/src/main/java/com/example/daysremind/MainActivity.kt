package com.example.daysremind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daysremind.database.RemindDatabase
import com.example.daysremind.model.RemindModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var remindDatabase : RemindDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        remindDatabase = RemindDatabase.getDatabase(this)
        initclickListners()
    }

    private fun initclickListners() {
        btnAdd.setOnClickListener {
            var remindModel = RemindModel(
                label = "Label 1",
                date_of_creation = "DD-MM-YYYY",
                target_date = "DD-MM-YYYY",
                desc = "Desc 1"
            )

            GlobalScope.launch {
                remindDatabase?.remindDao()?.insertRemindModel(remindModel)
            }

        }
    }
}