package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;

public class game_title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_title_selection);
    }
    public void back_genre(View v){
        Intent intent = new Intent(com.example.wanted.android.game_title.this,com.example.wanted.android.game_genre.class);
        startActivity(intent);
    }
    public void complete(View v){
        Intent intent = new Intent(com.example.wanted.android.game_title.this,com.example.wanted.android.new_registration.class);
        startActivity(intent);
    }
}