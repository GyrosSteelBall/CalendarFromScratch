package com.example.calendarfromscratch

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.time.LocalDate
import java.util.zip.Inflater


// THIS CLASS IS OUR RECYCLERVIEW ADAPTER, component of the recyclerview which will actually take supplied data and
// it will handle the data collection and bind it to our view

public class CalenderAdapter(private val days: ArrayList<LocalDate>, private val listener: onItemClickListener) : RecyclerView.Adapter<CalenderAdapter.ViewHolder>(){

    inner class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val dayOfTheWeek: TextView = itemView.findViewById(R.id.cellDayText);
        val parentView: View = itemView.findViewById(R.id.parentView);

        init{
            itemView.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            val position:Int = absoluteAdapterPosition;
            listener.onItemClick(position);
        }



    }
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }


    //inflate the item layout and creates the viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*
        val context = parent.context;
        val inflater = LayoutInflater.from(context); // Inflater takes input XML and builds View from it
        val contactView = inflater.inflate(R.layout.calender_cell,parent,false)
        val layoutParams : ViewGroup.LayoutParams = contactView.layoutParams;
        layoutParams.height = parent.height as Int;
         */

        val context = parent.context;
        val inflater = LayoutInflater.from(context);
        val contactView: View =  inflater.inflate(R.layout.calender_cell,parent,false);
       val layoutParams: ViewGroup.LayoutParams = contactView.layoutParams
        if(days.size > 15)
        {
            layoutParams.height = (parent.height * .08).toInt()
        }
        else {
            layoutParams.height = parent.height as Int
        }
        return ViewHolder(contactView);
    }

    // Determine the number of items


    //Set the view attributes based on the data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val day: LocalDate = days[position];
        holder.dayOfTheWeek.setText("${day.dayOfMonth}");


        val cmpToday = day.compareTo(CalenderUtils.today);
        when{
            cmpToday > 0 -> {

            }
            cmpToday < 0 -> {

            }
            else -> {
                holder.dayOfTheWeek.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,R.drawable.red_dot);

            }

        }
        val cmp = day.compareTo(CalenderUtils.selectedDate);
        when{
            cmp > 0 -> {
                holder.parentView.setBackgroundColor(Color.WHITE)
                holder.dayOfTheWeek.setTextColor(Color.BLACK);
                holder.dayOfTheWeek.setBackgroundResource(0);

            }
            cmp < 0 -> {
                holder.parentView.setBackgroundColor(Color.WHITE)
                holder.dayOfTheWeek.setTextColor(Color.BLACK);
                holder.dayOfTheWeek.setBackgroundResource(0);

            }
            else -> {
                //holder.parentView.setBackgroundColor(Color.LTGRAY);
                holder.dayOfTheWeek.setBackgroundResource(R.drawable.circle);

                holder.dayOfTheWeek.setTextColor(Color.WHITE);
            }
        }


    }

    override fun getItemCount(): Int {
        return days.size;
    }




}

