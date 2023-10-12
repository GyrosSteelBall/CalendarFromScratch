package com.example.calendarfromscratch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.ui.res.pluralStringResource


class ProgramsActivity : ComponentActivity(){

    lateinit var backButton: Button;
    lateinit var trainingCalender: TextView;
    lateinit var plusButton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.programs_activity);

        backButton = findViewById(R.id.backButton);
        trainingCalender = findViewById(R.id.TrainingCalendar);
        plusButton = findViewById(R.id.Plus);


    }

    fun goBack(view: View){
        finish();
    }
}