package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wanted.R;
import com.example.wanted.api.CreateUserDB;
import com.example.wanted.api.Test;
import com.example.wanted.async.AuthUser;
import com.example.wanted.async.SelectComm;

import java.net.MalformedURLException;
import java.net.URL;

public class CommSelection extends AppCompatActivity {

    SelectComm commSelect;
    private ListView lstv;
    private ArrayAdapter<Test> adapter;
    private CreateUserDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm_selection);

        commSelect = new SelectComm(CommSelection.this);


        commSelect.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent intent = new Intent(CommSelection.this, CommSelection.class);
                startActivity(intent);
            }
        });

        //　リストidを格納
        lstv = (ListView) findViewById(R.id.scroll);
        //Test中のtoStringとlist_viewとの結び付け
        adapter = new ArrayAdapter<Test>
                (this, R.layout.scroll_view, R.id.btn_scroll);
        //リストにセットする
        lstv.setAdapter(adapter);

        try {
            new SelectComm(CommSelection.this).execute(new URL("http://ec2-52-91-210-202.compute-1.amazonaws.com/Mail2/Comm"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        lstv.setAdapter(adapter);
/*        Button btn = findViewById(R.id.btn_scroll);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });*/
    }
}