package com.somnath_land_share_calculator.somnathlandsharecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        /////////////////////////////////////////////
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}