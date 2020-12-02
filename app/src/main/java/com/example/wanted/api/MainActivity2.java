package com.example.wanted;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void befor(View v){
        Intent intent = new Intent(com.example.wanted.MainActivity2.this, CommEnterRead.class);
        startActivity(intent);
    }
}