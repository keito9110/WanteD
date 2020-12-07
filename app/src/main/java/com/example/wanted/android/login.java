package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class login extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void login(View v){
        Intent intent = new Intent(login.this, AuthToken.class);
        startActivity(intent);
    }
    public void new_registration(View v){
        Intent intent = new Intent(login.this,registration.class);
        startActivity(intent);
    }
}