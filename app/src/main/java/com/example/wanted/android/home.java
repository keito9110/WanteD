package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wanted.R;
import com.example.wanted.api.CreateUserDB;
import com.example.wanted.api.Test;

public class home extends AppCompatActivity {
    private CreateUserDB helper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setContentView(R.layout.layout);
    }
    public void setName(){
        helper = new CreateUserDB(getApplicationContext());

        Button btn = (Button)findViewById(R.id.button16);
        btn.setText("");

    }

    @Override
    protected void onResume(){
        super.onResume();
        ImageButton ib1 = (ImageButton)findViewById(R.id.imageButton1);
        ImageButton ib2 = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton ib3 = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton ib4 = (ImageButton)findViewById(R.id.imageButton4);

        ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(home.this, home.class);
                startActivity(intent);
            }
        });

        ib2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(home.this, profile.class);
                startActivity(intent);
            }
        });

        ib3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(home.this, community.class);
                startActivity(intent);
            }
        });

        ib4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(home.this, gama_title_list.class);
                startActivity(intent);
            }
        });


    }
}