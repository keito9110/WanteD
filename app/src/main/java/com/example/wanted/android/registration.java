package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }


    public void back_login(View v) {
        Intent intent = new Intent(com.example.wanted.android.registration.this,com.example.wanted.android.login.class);
        startActivity(intent);
    }
    public void confirm(View v){
        Intent intent = new Intent(com.example.wanted.android.registration.this,com.example.wanted.android.new_confirm.class);
        startActivity(intent);
    }
}