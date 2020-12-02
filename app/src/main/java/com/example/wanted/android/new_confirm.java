package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class new_confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_registration_confirmation);
    }
    public void new_registration(View v){
        Intent intent = new Intent(com.example.wanted.android.new_confirm.this,com.example.wanted.android.login.class);
        startActivity(intent);
    }
    public void back_registration(View v){
        Intent intent = new Intent(com.example.wanted.android.new_confirm.this,com.example.wanted.android.registration.class);
        startActivity(intent);
    }
}