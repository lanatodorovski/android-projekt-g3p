package com.example.android_projekt_g3p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayActivity extends AppCompatActivity {


        Button dayBackBtn;
        Button dayNextBtn;
        TextView monthYearText;
        TextView dayWeekText;
        RecyclerView taskRecyclerView;
        Button addEventbtn;
        Button backToMonthBtn;

        LocalDate viewedDate;
         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.day_activity);

             Intent intent = getIntent();
             int dayInMonth = intent.getIntExtra("dan", 1);
             int month = intent.getIntExtra("mjesec", 0);
             int year = intent.getIntExtra("godina", 2024);

             viewedDate = LocalDate.of(year,month,dayInMonth);

             dayBackBtn = findViewById(R.id.buttonDay);
             dayNextBtn = findViewById(R.id.buttonDay2);
             monthYearText = findViewById(R.id.textViewMonthday);
             dayWeekText = findViewById(R.id.textViewDay);
            taskRecyclerView = findViewById(R.id.taksListRecycler);
            addEventbtn = findViewById(R.id.addEventBtn);
            backToMonthBtn = findViewById(R.id.toMonthBtn);

            SetDayView();
            dayBackBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewedDate = viewedDate.minusDays(1);
                    SetDayView();
                }
            });

             dayNextBtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     viewedDate = viewedDate.plusDays(1);
                     SetDayView();
                 }
             });

             addEventbtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                 }
             });
             backToMonthBtn.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                 }
             });

        }

        private void SetDayView(){
            monthYearText.setText(monthYearFromDate(viewedDate));
            dayWeekText.setText(dayWeekFromDate(viewedDate));
        }
        private String monthYearFromDate(LocalDate date){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            return  date.format(formatter);
        }
        private String dayWeekFromDate(LocalDate date){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd EEEE");
            return  date.format(formatter);
        }
}
