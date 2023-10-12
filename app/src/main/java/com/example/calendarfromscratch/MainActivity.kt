package com.example.calendarfromscratch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate


class MainActivity : ComponentActivity(), CalenderAdapter.onItemClickListener{

     lateinit var leftArrow: Button; lateinit var rightArrow: Button
     lateinit var mon: Button; lateinit var tue: Button;
    lateinit var thu: Button; lateinit var fri: Button;
    lateinit var sun: Button; lateinit var wed: Button;
    lateinit var sat: Button; lateinit var monText: Button;
    lateinit var selectedDate: LocalDate; lateinit var tueText: Button;
    lateinit var monthYearText: TextView; lateinit var wedText: Button;
    lateinit var thuText: Button; lateinit var friText: Button;
    lateinit var satText: Button; lateinit var sunText: Button;
    lateinit var MonthYearTextDisplay: Button;
    lateinit var adapter: CalenderAdapter;
    lateinit var exerciseAdapter: ExerciseAdapter;
    private lateinit var listView : ListView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initalizeWidgets()
        CalenderUtils.selectedDate = LocalDate.now();
        CalenderUtils.today = LocalDate.now();
        setWeekView();
        MonthYearTextDisplay = findViewById(R.id.MonthYearTextDisplay)
    }

    override fun onStart() {
        super.onStart()
        println("Start");
    }

    override fun onResume() {
        super.onResume()
        setExerciseAdapter()
        println("Resume");
    }

    override fun onPause() {
        super.onPause()
        println("Pause");
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Destroy");
    }

    override fun onRestart() {
        super.onRestart()
        println("Restart");
    }

    fun initalizeWidgets(){
        leftArrow = findViewById(R.id.leftArrow);rightArrow = findViewById(R.id.rightArrow)
        mon = findViewById(R.id.Monday); tue = findViewById(R.id.Tuesday);
        wed = findViewById(R.id.Wednesday); thu = findViewById(R.id.Thursday);
        fri = findViewById(R.id.Friday); sat = findViewById(R.id.Saturday);
        sun = findViewById(R.id.Sunday); monthYearText = findViewById(R.id.MonthYearTextDisplay);
        listView = findViewById(R.id.eventListView);
        exerciseAdapter = ExerciseAdapter(this, Exercise.exerciseList);
    }

    fun setWeekView(){
        monthYearText.setText(CalenderUtils.monthYearFromDate(CalenderUtils.selectedDate));
        CalenderUtils.weekdays = CalenderUtils.daysinWeekArray(CalenderUtils.selectedDate);
         adapter  = CalenderAdapter(CalenderUtils.weekdays,this);
        val weekdaysRecyclerView = findViewById<View>(R.id.weekdaysRecycleView) as RecyclerView  // Kotlin Typecast
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 7);
        weekdaysRecyclerView.layoutManager = layoutManager;
        weekdaysRecyclerView.adapter = adapter;
        setExerciseAdapter();

    }

    fun setPreviousWeek(view: View){
        CalenderUtils.selectedDate = CalenderUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    fun setNextWeek(view: View){
        CalenderUtils.selectedDate = CalenderUtils.selectedDate.plusWeeks(1);
       setWeekView();
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: LocalDate = CalenderUtils.weekdays.get(position);
        CalenderUtils.selectedDate = clickedItem;
        adapter.notifyDataSetChanged();
        setExerciseAdapter();
    }

    fun newExerciseAction(view: View){
        startActivity(Intent(this, ExerciseListActivity::class.java))
    }

    fun workoutActivityAction(view: View){
        startActivity(Intent(this, WorkoutActivity::class.java))
    }

    fun programActivityAction(view: View){
        startActivity(Intent(this, ProgramsActivity::class.java))
    }

    fun goMonthly(view: View){
        startActivity(Intent(this, MonthlyCalenderActivity::class.java))
    }



    private fun setExerciseAdapter() {
        val dailyExercises: ArrayList<Exercise> = Exercise.exercisesForDate(CalenderUtils.selectedDate);
        val exerciseAdapter = ExerciseAdapter(applicationContext, dailyExercises)
        listView.setAdapter(exerciseAdapter);
    }


}