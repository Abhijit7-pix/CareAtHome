package com.example.careathome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutUs extends AppCompatActivity {

    private TextView phoneNumberTextView;
    private TextView emailAddressTextView;
    private TextView physicalAddressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Initialize the TextViews
        phoneNumberTextView = findViewById(R.id.phone_number);
        emailAddressTextView = findViewById(R.id.email_address);
        physicalAddressTextView = findViewById(R.id.physical_address);

        // Set OnClickListener for phone number
        phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:91 9325907915")); // Replace with your phone number
                startActivity(intent);
            }
        });

        // Set OnClickListener for email address
        emailAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:careathome0247@gmail.com")); // Replace with your email address
                startActivity(intent);
            }
        });

        // Set OnClickListener for physical address
        physicalAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:18.2333856,75.6941478")); // Geo coordinates for Barshi, Solapur, Maharashtra
                startActivity(intent);
            }
        });
    }
}