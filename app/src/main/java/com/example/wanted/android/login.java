package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void login(View v){
        Intent intent = new Intent(com.example.wanted.android.login.this,com.example.wanted.android.new_registration.class);
        startActivity(intent);
    }
    public void new_registration(View v){
        Intent intent = new Intent(com.example.wanted.android.login.this,com.example.wanted.android.registration.class);
        startActivity(intent);
    }
}