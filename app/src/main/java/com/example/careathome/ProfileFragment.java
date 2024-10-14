package com.example.careathome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileFragment extends Fragment {

    private ImageView profileIcon;
    private TextView tvUserName, tvUserEmail;
    private Button  btnLogout;
    private TextView txtabout;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileIcon = view.findViewById(R.id.profile_icon);
        tvUserName = view.findViewById(R.id.txtusernme);
        tvUserEmail = view.findViewById(R.id.txtmail);
        txtabout= view.findViewById(R.id.txtabout);
        btnLogout = view.findViewById(R.id.btn_logout);

        // Initialize Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Load user data
        if (currentUser != null) {
            loadUserProfile(currentUser);
        }

        // Logout functionality
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Toast.makeText(getActivity(), "Logged out successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        // About Us functionality
        txtabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle About Us button click (e.g., navigate to About Us activity or show a dialog)
                Toast.makeText(getActivity(), "About Us clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void loadUserProfile(FirebaseUser currentUser) {
        // Load email directly from FirebaseAuth
        tvUserEmail.setText(currentUser.getEmail());

        // Load other details from Firebase Realtime Database
        databaseReference.child(currentUser.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DataSnapshot dataSnapshot = task.getResult();
                if (dataSnapshot.exists()) {
                    String username = dataSnapshot.child("username").getValue(String.class);
                    tvUserName.setText(username);
                }
            } else {
                Toast.makeText(getActivity(), "Failed to load user profile", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
