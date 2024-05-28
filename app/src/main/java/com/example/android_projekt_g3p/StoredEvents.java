package com.example.android_projekt_g3p;

import android.content.SharedPreferences;
import android.media.metrics.Event;
import android.preference.PreferenceManager;

import org.json.JSONArray;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class StoredEvents {
        static ArrayList<StoredEvents> eventList = new ArrayList<StoredEvents>();
        public String eventName;
        public LocalDate eventDate;
        public boolean hasTime;
        public LocalTime eventTime;
        public  boolean hasNotifications;

        public String eventType;

        public StoredEvents(String eventName, LocalDate eventDate, boolean hasTime, LocalTime eventTime, boolean hasNotifications, String eventType) {
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.hasTime = hasTime;
            this.eventTime = eventTime;
            this.hasNotifications = hasNotifications;
            this.eventType = eventType;

            eventList.add(this);
        }
        public  StoredEvents(){

        }
}





