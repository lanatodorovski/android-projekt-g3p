package com.example.android_projekt_g3p;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.metrics.Event;
import android.preference.PreferenceManager;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.prefs.Preferences;

public class StoredEvents {
        public static ArrayList<StoredEvents> eventList = new ArrayList<StoredEvents>();
        public static JSONArray jsonEventList = new JSONArray();
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
            toJson(this);
        }
        public  StoredEvents(){

        }

        private void toJson( StoredEvents storedEvents){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("eventName", storedEvents.eventName);
                jsonObject.put("eventDate", storedEvents.eventDate.toString());
                jsonObject.put("hasTime", storedEvents.hasTime);
                jsonObject.put("eventTime", storedEvents.eventTime.toString());
                jsonObject.put("hasNotifications", storedEvents.hasNotifications);
                jsonObject.put("eventType", storedEvents.eventType);
            }catch (Exception e){
                Log.e("error", e.toString());
            }
            this.jsonEventList.put(jsonObject);
        }

        public void  setFromJson(JSONArray jsonEventListNew){
            try {
                if(jsonEventListNew.length() == 0){
                    Log.i("msg", "PRAZAN JSON EVENZ SLTI");
                }
                for(int i = 0; i <  jsonEventListNew.length(); i++){
                    JSONObject jsonEvent=  jsonEventListNew.getJSONObject(i);
                    StoredEvents newStoredEvent = new StoredEvents(
                                jsonEvent.getString("eventName"),
                                LocalDate.parse(jsonEvent.getString("eventDate")),
                                jsonEvent.getBoolean("hasTime"),
                                LocalTime.parse(jsonEvent.getString("eventTime")),
                                jsonEvent.getBoolean("hasNotifications"),
                                jsonEvent.getString("eventType"));
                    Log.i("informacije", ""+jsonEvent.getBoolean("hasNotifications"));
                }
            } catch (JSONException e) {
                Log.e("error", e.toString());
            }
        }
}





