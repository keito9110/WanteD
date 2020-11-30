package com.example.wanted.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanted.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void befor(View v){
        Intent intent = new Intent(MainActivity2.this, CommEnterRead.class);
        startActivity(intent);
    }
}