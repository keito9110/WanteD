package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    }
    public void setName(){
        helper = new CreateUserDB(getApplicationContext());

        Button btn = (Button)findViewById(R.id.button16);
        btn.setText("");

    }
}