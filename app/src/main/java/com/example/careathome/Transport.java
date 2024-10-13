package com.example.careathome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.careathome.R;

import java.util.ArrayList;
import java.util.List;

public class Transport extends Activity {
    private RecyclerView transportationServicesListView;
    private Button buttonBookNow;
    private List<String> transportationServices;
    private TransportationServiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        transportationServicesListView = findViewById(R.id.list_view);
        buttonBookNow = findViewById(R.id.button_book_now);
        transportationServices = new ArrayList<>();

        // Add transportation services to the list
        transportationServices.add("Pickup Truck");
        transportationServices.add("Tempo");
        transportationServices.add("Mini Truck");
        transportationServices.add("Large Truck");
        transportationServices.add("Container Truck");
        transportationServices.add("Refrigerated Truck");
        transportationServices.add("Flatbed Truck");
        transportationServices.add("Step Deck Truck");
        transportationServices.add("Lowboy Truck");

        // Create a TransportationServiceAdapter to display the list of transportation services
        adapter = new TransportationServiceAdapter(transportationServices);

        // Set the adapter to the RecyclerView
        transportationServicesListView.setAdapter(adapter);

        // Set the layout manager to the RecyclerView
        transportationServicesListView.setLayoutManager(new LinearLayoutManager(this));

        // Set an OnClickListener for the Book Now button
        buttonBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Book Now button click event
            }
        });
    }
}