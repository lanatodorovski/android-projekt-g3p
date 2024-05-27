package com.example.android_projekt_g3p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity {

    EditText eventNameInput;
    Switch hasTimeSwitch;
    EditText eventTimeHourInput;
    EditText eventTimeMinutesInput;
    Switch hasNotificationSwitch;

    Button addEventBtn;
    Button cancelBtn;
    String eventName;
    LocalDate eventDate;
    boolean hasTime;
    LocalTime eventTime;
    boolean hasNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_activity);

        Intent intent = getIntent();
        int dayInMonth = intent.getIntExtra("dan", 1);
        int month = intent.getIntExtra("mjesec", 1);
        int year = intent.getIntExtra("godina", 2024);
        eventDate = LocalDate.of(year, month, dayInMonth);


        eventNameInput = findViewById(R.id.editTextText);
        hasTimeSwitch = findViewById(R.id.switch1);
        eventTimeHourInput = findViewById(R.id.editTextText2);
        eventTimeMinutesInput = findViewById(R.id.editTextText3);
        hasNotificationSwitch = findViewById(R.id.switch2);
        addEventBtn = findViewById(R.id.button3);
        cancelBtn = findViewById(R.id.button4);

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean canAdd = true;
                if(eventNameInput.getText().toString().trim().length() != 0){
                    eventName = eventNameInput.toString().trim();
                }else{
                    canAdd = false;
                    Toast.makeText(getApplicationContext(),"Naziv događaja nesmije biti prazan", Toast.LENGTH_SHORT).show();
                }

                if(!hasTime || !canAdd){
                    eventTime = LocalTime.of(00,00,00);
                    hasNotification = false;
                }else{
                    try {
                        int eventTimeHour = Integer.parseInt(eventTimeHourInput.getText().toString());
                        int eventTimeMinutes = Integer.parseInt(eventTimeMinutesInput.getText().toString());
                        eventTime = LocalTime.of(eventTimeHour,eventTimeMinutes, 00);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Sati i minute nisu postavljeni u traženom formatu", Toast.LENGTH_SHORT).show();
                        canAdd = false;
                    }
                    hasNotification = hasNotificationSwitch.isChecked();

                }

            }
        });

        hasTimeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hasTime = !isChecked;

                hasNotificationSwitch.setEnabled(hasTime);
                eventTimeHourInput.setEnabled(hasTime);
                eventTimeMinutesInput.setEnabled(hasTime);

                if(!hasTime){
                    hasNotificationSwitch.setChecked(false);
                    eventTimeHourInput.setText("");
                    eventTimeMinutesInput.setText("");
                }
            }
        });
    }
}