package com.example.android_projekt_g3p;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {
    public final TextView eventNameOutput;
    public final TextView eventTimeOutput;
    public final TextView eventTypeOutput;
    public final ImageView notificationImage;
    public EventViewHolder(@NonNull View itemView) {
        super(itemView);

        eventNameOutput = itemView.findViewById(R.id.textViewDogadajNaziv);
        eventTimeOutput = itemView.findViewById(R.id.textViewVrijeme);
        eventTypeOutput = itemView.findViewById(R.id.textViewTip);
        notificationImage = itemView.findViewById(R.id.notificationSlika);
    }
}
