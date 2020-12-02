package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class event_registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_registration);
    }
    public void syousai(View v){
        Intent intent = new Intent(com.example.wanted.android.event_registration.this,com.example.wanted.api.CommEnterRead.class );
        startActivity(intent);
    }

}