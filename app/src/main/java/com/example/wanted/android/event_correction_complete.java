package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;
import com.example.wanted.api.CommEnterRead;

public class event_correction_complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_correction_completed);
    }
    public void syousai(View v){
        Intent intent = new Intent(com.example.wanted.android.event_correction_complete.this,com.example.wanted.api.CommEnterRead.class );
        startActivity(intent);
    }
    public void comm(View v){
        Intent intent = new Intent(com.example.wanted.android.event_correction_complete.this, com.example.wanted.api.CommEnterRead.class);
        startActivity(intent);
    }
}