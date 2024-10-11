package com.example.careathome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    CardView cardelectrician, cardcarpenter, cardmechanic, cardplumber, cardmaid, cardcaretaker, cardgardener, cardhairdresser, cardtow;
    CardView cardappliance, cardphotographer, cardwelding, cardbarber, cardtransport, cardacservice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardelectrician = view.findViewById(R.id.crdElectrician);
        cardcarpenter = view.findViewById(R.id.crdCarpenter);
        cardmechanic = view.findViewById(R.id.crdMechanic);
        cardplumber = view.findViewById(R.id.crdPlumber);
        cardmaid = view.findViewById(R.id.crdMaid);
        cardcaretaker = view.findViewById(R.id.crdCaretaker);
        cardgardener = view.findViewById(R.id.crdGardener);
        cardhairdresser = view.findViewById(R.id.crdHairdresser);
        cardtow = view.findViewById(R.id.crdTow);
        cardappliance = view.findViewById(R.id.crdAppliance);
        cardphotographer = view.findViewById(R.id.crdPhotographer);
        cardwelding = view.findViewById(R.id.crdWelder);
        cardbarber = view.findViewById(R.id.crdBarber);
        cardtransport = view.findViewById(R.id.crdTransport);
        cardacservice = view.findViewById(R.id.crdAcservice);

        cardelectrician.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Electrical");
            startActivity(intent);
        });

        cardcarpenter.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Carpenter");
            startActivity(intent);
        });

        cardmechanic.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Mechanic");
            startActivity(intent);
        });

        cardplumber.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Plumbing");
            startActivity(intent);
        });
        cardmaid.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Maid");
            startActivity(intent);
        });

        cardcaretaker.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "CareTaker");
            startActivity(intent);
        });

        cardgardener.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Gardener");
            startActivity(intent);
        });

        cardhairdresser.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Beauty Parlor");
            startActivity(intent);
        });

        cardtow.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Towing Service");
            startActivity(intent);
        });

        cardappliance.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Appliance Repairing");
            startActivity(intent);
        });

        cardphotographer.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Photography");
            startActivity(intent);
        });

        cardwelding.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Welding");
            startActivity(intent);
        });

        cardbarber.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Barber");
            startActivity(intent);
        });

        cardtransport.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "Transportation");
            startActivity(intent);
        });

        cardacservice.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Appointment_Screen.class);
            intent.putExtra("serviceName", "AC Service");
            startActivity(intent);
        });
    }
}
