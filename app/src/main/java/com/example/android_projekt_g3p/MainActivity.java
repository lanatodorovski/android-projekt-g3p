package com.example.android_projekt_g3p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;

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
    }
}