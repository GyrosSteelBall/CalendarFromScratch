package com.example.calendarfromscratch

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate


class MonthlyCalenderActivity : ComponentActivity(),CalenderAdapter.onItemClickListener{

    lateinit var monthYearText: TextView;
    lateinit var adapter: CalenderAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monthly_calender_activity);
        monthYearText = findViewById(R.id.monthlyYearText);
        setMonthView();
    }

    fun setMonthView(){
        monthYearText.setText(CalenderUtils.monthYearFromDate(CalenderUtils.selectedDate));
        CalenderUtils.monthdays = CalenderUtils.daysinMonthArray(CalenderUtils.selectedDate);
        adapter  = CalenderAdapter(CalenderUtils.monthdays,this);
        val weekdaysRecyclerView = findViewById<View>(R.id.monthlyRecycleView) as RecyclerView  // Kotlin Typecast
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 7,RecyclerView.VERTICAL,false);
        weekdaysRecyclerView.layoutManager = layoutManager;
        weekdaysRecyclerView.adapter = adapter;
    //    setExerciseAdapter();

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: LocalDate = CalenderUtils.monthdays.get(position);
        CalenderUtils.selectedDate = clickedItem;
        adapter.notifyDataSetChanged();
     //   setExerciseAdapter();
    }

    fun nextMonth(view: View){
        CalenderUtils.selectedDate = CalenderUtils.selectedDate.plusMonths(1);
        setMonthView();
    }

    fun prevMonth(view:View){
        CalenderUtils.selectedDate = CalenderUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    fun goBack(view:View){
        finish();
    }
}