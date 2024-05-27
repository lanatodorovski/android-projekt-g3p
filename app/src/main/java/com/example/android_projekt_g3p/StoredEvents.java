package com.example.android_projekt_g3p;

import android.content.SharedPreferences;
import android.media.metrics.Event;
import android.preference.PreferenceManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class StoredEvents {
    static ArrayList<MyEvent> eventList = new ArrayList<MyEvent>();

    public class MyEvent {
        String eventName;
        LocalDate eventDate;
        boolean hasTime;
        LocalTime eventTime;
        boolean hasNotifications;

        public MyEvent(String eventName, LocalDate eventDate, boolean hasTime, LocalTime eventTime, boolean hasNotifications) {
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.hasTime = hasTime;
            this.eventTime = eventTime;
            this.hasNotifications = hasNotifications;

            eventList.add(this);
        }
    }


    
}

