package com.example.calendarfromscratch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//Adapter will take in input data set
//IT will create a view for each element in our data set
// It will then add each view into our listview viola, adapter connects data to listview
class ExerciseAdapter(private val context: Context, private val dataSource: ArrayList<Exercise>) : BaseAdapter() {
    override fun getCount(): Int {
        return dataSource.size;
    }

    override fun getItem(position: Int): Exercise {
       return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent:ViewGroup): View {
        val inflater = LayoutInflater.from(context); // Inflater takes input XML and builds View from it
        val rowView = inflater.inflate(R.layout.event_cell,parent,false);

        var exercise : Exercise  = getItem(position);
        var exerciseCellTV : TextView = rowView.findViewById(R.id.exerciseCellTV);
        exerciseCellTV.setText("${exercise.name}");

        return rowView;
    }

}