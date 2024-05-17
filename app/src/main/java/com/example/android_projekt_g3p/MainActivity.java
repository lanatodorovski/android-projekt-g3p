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
    private LocalDate selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthYearText = findViewById(R.id.textView);
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        selectedDate = LocalDate.now();

        monthYearText.setText(monthYearFromDate(selectedDate));
        //ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);
        daysInMonthArray(selectedDate);
    }
    private void daysInMonthArray(LocalDate date){
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();


        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        TemporalField fieldISO = WeekFields.of(Locale.UK).dayOfWeek();
        LocalDate lastMondayOfMonthBefore = selectedDate.withDayOfMonth(1).with(fieldISO,1);
        int dayOfWeek = 7 - lastMondayOfMonthBefore.until(firstOfMonth).getDays();
        monthYearText.setText(daysInMonth+ ", "+ dayOfWeek +"," + firstOfMonth);

    }

    private String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return  date.format(formatter);
    }
}