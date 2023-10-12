package com.example.calendarfromscratch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ExerciseListActivity : ComponentActivity() {


    lateinit var backButton: Button;
    lateinit var trainingCalender: TextView;
    lateinit var plusButton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercises_activity);

        backButton = findViewById(R.id.Exercise_Back_Button);
        plusButton = findViewById(R.id.Exercise_Plus_Button);


    }

    fun goBack(view: View){
        finish();
    }

    fun addExercise(view: View){
            startActivity(Intent(this, ExerciseActivity::class.java))
    }
}