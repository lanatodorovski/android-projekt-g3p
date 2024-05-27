package com.example.android_projekt_g3p;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

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
                if(eventNameInput.toString().trim().length() != 0){
                    eventName = eventNameInput.toString().trim();
                }
                hasTime = hasTimeSwitch.isActivated();
                if(!hasTime){
                    
                }
            }
        });
    }
}