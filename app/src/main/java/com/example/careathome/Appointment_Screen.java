package com.example.careathome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Appointment_Screen extends AppCompatActivity {

    private ImageView imgServiceIcon;
    private CalendarView calendarView;
    private LinearLayout servicePriceContainer;
    private TextView tvServiceName;
    private TextView tvServicePrice;
    private Button btnContinue;
    private String selectedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_screen);

        // Initialize views
        imgServiceIcon = findViewById(R.id.img_service_icon);
        calendarView = findViewById(R.id.calendarView);
        servicePriceContainer = findViewById(R.id.service_price_container);
        tvServiceName = findViewById(R.id.tv_service_name);
        tvServicePrice = findViewById(R.id.tv_service_price);
        btnContinue = findViewById(R.id.btn_continue);

        Intent intent=getIntent();
        selectedService=intent.getStringExtra("serviceName");
        if (selectedService!=null){
            tvServiceName.setText(selectedService);
        }
        else {
            tvServiceName.setText("Unknown Service");
        }
    }


}