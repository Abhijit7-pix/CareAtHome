package com.example.careathome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Appointment_Screen extends AppCompatActivity {

    private ImageView imgServiceIcon;
    private CalendarView calendarView;
    private LinearLayout servicePriceContainer;
    private TextView tvServiceName;
    private TextView tvServicePrice;
    private Button btnContinue;
    private String selectedService;
    private String selectedDate;
    DatabaseReference appointmentsRef;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_screen);

        mAuth=FirebaseAuth.getInstance();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        appointmentsRef= database.getReference("appointments");

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

        setServicePrice(selectedService);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar calendar=Calendar.getInstance();
                calendar.set(year, month,dayOfMonth);
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
                selectedDate=dateFormat.format(calendar.getTime());
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment();
            }
        });
    }

    private void setServicePrice(String serviceName){
        switch (serviceName){
            case "Electrical":
                tvServicePrice.setText("₹ 500");
                break;
            case "Carpentry":
                tvServicePrice.setText("₹ 400");
                break;
            case "Bike Repair":
                tvServicePrice.setText("₹ 500");
                break;
            case "Plumbing":
                tvServicePrice.setText("₹ 500");
                break;
            case "Maid":
                tvServicePrice.setText("₹ 500");
                break;
            case "Care Taker":
                tvServicePrice.setText("₹ 500");
                break;
            case "Gardening":
                tvServicePrice.setText("₹ 500");
                break;
            case "Beautician":
                tvServicePrice.setText("₹ 500");
                break;
            case "Towing":
                tvServicePrice.setText("₹ 500");
                break;
            case "Appliance Repairing":
                tvServicePrice.setText("₹ 500");
                break;
            case "Photography":
                tvServicePrice.setText("₹ 500");
                break;
            case "Welding":
                tvServicePrice.setText("₹ 500");
                break;
            case "Barber":
                tvServicePrice.setText("₹ 500");
                break;
            case "Transportation":
                tvServicePrice.setText("₹ 500");
                break;
            case "AC Servicing":
                tvServicePrice.setText("₹ 500");
                break;
        }
    }

    private void bookAppointment() {
        String serviceName=tvServiceName.getText().toString();
        String servicePrice=tvServicePrice.getText().toString();
        String uid=mAuth.getCurrentUser().getUid();

        if (selectedService==null){
            Toast.makeText(Appointment_Screen.this,"Please select a date",Toast.LENGTH_SHORT).show();
            return;
        }
        Appointments appointments=new Appointments(serviceName,servicePrice,selectedDate,uid);
        String appointmentId= appointmentsRef.push().getKey();
        appointmentsRef.child(appointmentId).setValue(appointments).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(Appointment_Screen.this,"Appointment booked successfully",Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(Appointment_Screen.this,"Failed to book the Appointment",Toast.LENGTH_SHORT).show();

            }
        });
    }


}