package com.example.android_projekt_g3p;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import org.json.JSONArray;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AddEventActivity extends AppCompatActivity {

    EditText eventNameInput;
    Switch hasTimeSwitch;
    EditText eventTimeHourInput;
    EditText eventTimeMinutesInput;
    Switch hasNotificationSwitch;

    RadioButton radioSkola;
    RadioButton radioDruzenja;
    RadioButton radioSport;
    RadioButton radioRodendani;
    RadioGroup radioGroup;
    Button addEventBtn;
    Button cancelBtn;
    String eventName;
    LocalDate eventDate;
    boolean hasTime;
    LocalTime eventTime;
    boolean hasNotification;
    String eventType;
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

        radioGroup = findViewById(R.id.radioGroup);
        radioSkola = findViewById(R.id.radioButton);
        radioDruzenja = findViewById(R.id.radioButton2);
        radioSport = findViewById(R.id.radioButton3);
        radioRodendani = findViewById(R.id.radioButton4);

        radioSkola.setChecked(true);
        eventType = "Škola";
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radioSkola.isChecked()){
                    eventType = "Škola";
                }else if(radioDruzenja.isChecked()){
                    eventType = "Druženje";
                }else if(radioSport.isChecked()){
                    eventType = "Sport";
                }else if(radioRodendani.isChecked()){
                    eventType = "Rođendan";
                }
            }
        });


        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid = CheckValidation();
                if(isValid){
                    StoredEvents event = new StoredEvents(eventName,eventDate,hasTime,eventTime,hasNotification, eventType);
                    onBackPressed();
                }


            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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

    private boolean CheckValidation(){
        boolean canAdd = true;
        if(eventNameInput.getText().toString().trim().length() != 0){
            eventName = eventNameInput.getText().toString().trim();
        }else{
            canAdd = false;
            Toast.makeText(getApplicationContext(),
                    "Naziv događaja nesmije biti prazan",
                    Toast.LENGTH_SHORT)
                    .show();
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
                Toast.makeText(getApplicationContext(),
                        "Sati i minute nisu postavljeni u traženom formatu",
                        Toast.LENGTH_SHORT)
                        .show();
                canAdd = false;
            }
            hasNotification = hasNotificationSwitch.isChecked();

        }
        return canAdd;
    }
}