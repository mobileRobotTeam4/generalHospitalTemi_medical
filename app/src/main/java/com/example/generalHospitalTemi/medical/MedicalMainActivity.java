package com.example.generalHospitalTemi.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.generalHospitalTemi.R;
import com.example.generalHospitalTemi.databinding.ActivityMainBinding;
import com.example.generalHospitalTemi.databinding.ActivityMedicalMainBinding;
import com.example.generalHospitalTemi.medical.emergency.EmergencyActivity;
import com.example.generalHospitalTemi.medical.get.GetActivity1;
import com.example.generalHospitalTemi.medical.request.RequestActivity1;
import com.example.generalHospitalTemi.patient.PatientMainActivity;
import com.example.generalHospitalTemi.patient.PatientTempertureActivity;
import com.example.generalHospitalTemi.temi.RoboTemiListeners;

public class MedicalMainActivity extends AppCompatActivity {

    private ActivityMedicalMainBinding binding;
    RoboTemiListeners roboTemiListeners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMedicalMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        roboTemiListeners = new RoboTemiListeners();
        binding.codeblueImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MedicalMainActivity.this, EmergencyActivity.class);
                startActivity(intent);
            }
        });
        binding.suppliesReqImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalMainActivity.this, RequestActivity1.class);
                startActivity(intent);
            }
        });

        binding.suppliesRecImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalMainActivity.this, GetActivity1.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


    }
    public void skidJoy(float vel , int sec) {// 이동 예시
        //정면 방향으로 sec 초간 이동하라
        long t = System.currentTimeMillis();
        long end = t + 1000*sec;
        while (System.currentTimeMillis() < end) {
            roboTemiListeners.skidJoy(vel, 0F);
        }
    }
}