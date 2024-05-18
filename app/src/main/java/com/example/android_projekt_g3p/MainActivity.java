package com.example.android_projekt_g3p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthYearText = findViewById(R.id.textView);
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        currentDate = LocalDate.now();

        git 




        setMonthView(currentDate);
    }

    private void setMonthView(LocalDate date){
        monthYearText.setText(monthYearFromDate(date));
        ArrayList<String> daysInMonth = daysInMonthArray(date);
    }
    private ArrayList<String> daysInMonthArray(LocalDate date){
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = date.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        monthYearText.setText("" + dayOfWeek+ ", "+firstOfMonth);

        for (int i = 1 ; i <= 42; i++){
            if(i < dayOfWeek || i > daysInMonth + dayOfWeek - 1){
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