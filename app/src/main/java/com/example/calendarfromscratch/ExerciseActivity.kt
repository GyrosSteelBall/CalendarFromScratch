package com.example.calendarfromscratch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.time.LocalDate
import java.time.LocalTime

class ExerciseActivity : ComponentActivity() {

    lateinit var name: EditText;
    lateinit var date: TextView; lateinit var time: TextView;
    lateinit var curTime : LocalTime;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_event_action)
        initWidgets();
        curTime = LocalTime.now();
        date.setText("Date: " + CalenderUtils.formattedDate(CalenderUtils.selectedDate));
        time.setText("Time: " + CalenderUtils.formattedTime(curTime));

    }

    fun initWidgets(){
        name = findViewById(R.id.ExerciseName);
        date = findViewById(R.id.ExerciseDate);
        time = findViewById(R.id.ExerciseTime);
    }

    fun saveExercise(view: View){
        var exerciseName : String = name.text.toString();
        var newExercise : Exercise = Exercise(exerciseName, CalenderUtils.selectedDate, curTime);
        Exercise.exerciseList.add(newExercise);
        finish();
    }

}