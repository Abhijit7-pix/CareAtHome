package com.example.careathome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView; // Add this import

import java.util.List;

public class TransportationServiceAdapter extends RecyclerView.Adapter<TransportationServiceAdapter.ViewHolder> {
    private List<String> transportationServices;

    public TransportationServiceAdapter(List<String> transportationServices) {
        this.transportationServices = transportationServices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transport_service_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String serviceName = transportationServices.get(position);
        holder.serviceNameTextView.setText(serviceName); // This should work now
    }

    @Override
    public int getItemCount() {
        return transportationServices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public MaterialTextView serviceNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceNameTextView = itemView.findViewById(R.id.service_name_text_view);
        }
    }
}