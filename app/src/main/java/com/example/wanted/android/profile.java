package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }
    public void profile(View v){
        Intent intent = new Intent(com.example.wanted.android.profile.this,com.example.wanted.android.profile_change.class);
        startActivity(intent);
    }
}