package com.example.calendarfromscratch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class WorkoutActivity : ComponentActivity() {
    lateinit var backButton: ImageButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workouts_activity);
        backButton = findViewById(R.id.backButtonWorkout);
    }

    fun goBack(view: View){
        finish();
    }
}