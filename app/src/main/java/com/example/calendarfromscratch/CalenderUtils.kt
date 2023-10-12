package com.example.calendarfromscratch

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.YearMonth
import java.time.format.DateTimeFormatter


object CalenderUtils {


        lateinit var selectedDate: LocalDate;
        lateinit var weekdays: ArrayList<LocalDate>;
        lateinit var monthdays: ArrayList<LocalDate>;
        lateinit var today: LocalDate;


    fun monthYearFromDate(date: LocalDate): String{

        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    fun formattedDate(date: LocalDate): String{
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM YYYY")
        return date.format(formatter);
    }

    fun formattedTime(time: LocalTime):String{
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }

    fun DayFromDate(date: LocalDate): String{
        var dayString : String = "dd";
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(dayString);
        return date.format(formatter);
    }

    fun daysinMonthArray(date: LocalDate) : ArrayList<LocalDate>{
        val daysInMonthArray = ArrayList<LocalDate>()
        val yearMonth = YearMonth.from(date)

        val daysInMonth = yearMonth.lengthOfMonth()

        val firstOfMonth: LocalDate = CalenderUtils.selectedDate.withDayOfMonth(1)
        val dayOfWeek: Int = firstOfMonth.dayOfWeek.value

        for(i in 1..42)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {

            }
            else{
                daysInMonthArray.add(LocalDate.of(selectedDate.year, selectedDate.month,i-dayOfWeek));
            }

        }
        return daysInMonthArray
    }

    fun daysinWeekArray(date: LocalDate) : ArrayList<LocalDate>{
       var days : ArrayList<LocalDate> = ArrayList<LocalDate>();
        var current: LocalDate = sundayForDate(selectedDate);
        var endDate: LocalDate = current.plusWeeks(1);

        while(current.isBefore(endDate))
        {
          //  Log.i("NumberGenerated", "Function has generated One.");
            days.add(current);
            current = current.plusDays(1);
        }
        return days;
    }

    fun sundayForDate(current: LocalDate) : LocalDate{
            var currentDate : LocalDate = current;
            var oneWeekAgo = current.minusWeeks(1);

            while(currentDate.isAfter(oneWeekAgo))
            {
              //  Log.i("NumberGenerated", "Function has generated zero.");
                if(currentDate.dayOfWeek == DayOfWeek.SUNDAY)
                        return currentDate;

                currentDate = currentDate.minusDays(1);
            }
        return currentDate;
    }

    /*
    fun daysinWeekArray(selectedDate: LocalDate) : ArrayList<String>
    {

    }
     */


}