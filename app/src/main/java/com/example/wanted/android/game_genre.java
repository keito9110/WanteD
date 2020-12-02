package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class game_genre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_genre);
    }
    public void Back(View v){
        Intent intent = new Intent(com.example.wanted.android.game_genre.this,com.example.wanted.android.login.class );
        startActivity(intent);
    }
    public void Next(View v){
        Intent intent = new Intent(com.example.wanted.android.game_genre.this,com.example.wanted.android.game_title.class );
        startActivity(intent);
    }
}