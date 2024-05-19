package com.example.android_projekt_g3p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate currentDate;

    private int changedMonths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthYearText = findViewById(R.id.textView);
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        currentDate = LocalDate.now();
        changedMonths = 0;

        setMonthView(currentDate);
    }

    public void previousMonthAction(View view){
        changedMonths--;
        setMonthView(currentDate.plusMonths(changedMonths));
    }

    public void nextMonthAction (View view){
        changedMonths++;
        setMonthView(currentDate.plusMonths(changedMonths));

    }
    private void setMonthView(LocalDate date){
        monthYearText.setText(monthYearFromDate(date));
        ArrayList<String> daysInMonth = daysInMonthArray(date);
        System.out.println(daysInMonth);

    }
    private ArrayList<String> daysInMonthArray(LocalDate date){
        ArrayList<String> daysInMonthArray = new ArrayList<>();

        YearMonth yearMonth = YearMonth.from(date);
        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = date.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1 ; i <= 42; i++){
            if(i < dayOfWeek || i >= daysInMonth + dayOfWeek){
                daysInMonthArray.add(" ");
            }else{
                daysInMonthArray.add(String.valueOf(i - dayOfWeek + 1));

            }
        }
        return daysInMonthArray;
    }
    private String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return  date.format(formatter);
    }



}