package com.example.android_projekt_g3p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private ArrayList<StoredEvents> storedEvents;
    public EventAdapter (ArrayList<StoredEvents> storedEvents){
        this.storedEvents = storedEvents;
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.event_card, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        StoredEvents event = storedEvents.get(position);
        holder.eventNameOutput.setText("Naziv: "+ event.eventName);

        if(event.hasTime){
            holder.eventTimeOutput.setText("Vrijeme: "+ event.eventTime.toString());
        }else{
            holder.eventTimeOutput.setText("Vrijeme: Neodređeno");
        }

        holder.eventTypeOutput.setText("Tip: "+ event.eventType);

        if(!event.hasNotifications){
            holder.notificationImage.setVisibility(View.INVISIBLE);
        }
        
    }

    @Override
    public int getItemCount() {
        return storedEvents.size();
    }
}
