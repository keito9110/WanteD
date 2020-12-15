package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wanted.R;
import com.example.wanted.api.CreateUserDB;
import com.example.wanted.api.Test;
import com.example.wanted.async.SelectComm;
import com.example.wanted.session.Comm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chat extends AppCompatActivity {

    private TextView textView;
    EditText edit_text_key;
    private ListView lstv;
    private ArrayAdapter<Test> adapter;
    private CreateUserDB helper;
    SelectComm commSelect;
    Comm comm;
    MutableLiveData<String> result;

    public MutableLiveData<String> getResult(){
        if(result == null){
            result = new MutableLiveData<>();
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        commSelect = new SelectComm(Chat.this);

        commSelect.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent intent = new Intent(Chat.this, Chat.class);
                startActivity(intent);
            }
        });
        // DB作成
        helper = new CreateUserDB(getApplicationContext());

        // 変数textViewに表示するテキストビューのidを格納
        textView = findViewById(R.id.text_view);

        //　リストidを格納
        lstv = (ListView) findViewById(R.id.ListChat);
        //Test中のtoStringとlist_viewとの結び付け
        adapter = new ArrayAdapter<Test>
                (this, R.layout.list_view, R.id.txtout);
        //リストにセットする
        lstv.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void send(View v){
        ContentValues values = new ContentValues();

        EditText editText = findViewById(R.id.chat);
        String send = editText.getText().toString();
        values.put("chat_contents", send);
        String time = nowDate();
        values.put("send_time" ,time);

    }
    public String nowDate(){
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("hh:MM");
        return df.format(today);
    }
}
