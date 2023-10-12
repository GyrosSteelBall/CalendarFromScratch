package com.example.calendarfromscratch

import android.graphics.Color
import java.time.LocalDate
import java.time.LocalTime

class Exercise(var name : String, val date : LocalDate, var time : LocalTime ) {

    companion object{
        var exerciseList: ArrayList<Exercise> = ArrayList<Exercise>();
        fun exercisesForDate(date: LocalDate) : ArrayList<Exercise>{
            var exercises: ArrayList<Exercise> = ArrayList<Exercise>();

            for(curExercise in exerciseList)
            {
                if(curExercise.date.isEqual(date))
                        exercises.add(curExercise);


            }
            return exercises;
        }
    }

}