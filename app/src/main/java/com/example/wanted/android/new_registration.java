package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class new_registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_registration_completed);
    }
    public void registration_home(View v){
        Intent intent = new Intent(com.example.wanted.android.new_registration.this,com.example.wanted.android.home.class);
        startActivity(intent);
    }
}