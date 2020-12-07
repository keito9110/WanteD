package com.example.wanted.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.wanted.R;
import com.example.wanted.async.AuthUser;

import java.net.MalformedURLException;
import java.net.URL;

public class AuthToken extends AppCompatActivity {

    AuthUser authUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_token);

        authUser = new AuthUser(AuthToken.this);

        authUser.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent intent = new Intent(AuthToken.this, game_genre.class);
                startActivity(intent);
            }
        });
    }

    public void auth(View v){
        EditText editId = findViewById(R.id.ed_id);
        EditText editToken = findViewById(R.id.ed_id2);
        String id = editId.getText().toString();
        String token = editToken.getText().toString();

        try {
            authUser.execute(new URL("http://ec2-52-91-210-202.compute-1.amazonaws.com/Mail2/auth?token="+token+"&id="+ id));
            TextView textErr = findViewById(R.id.err);
            String err = textErr.getText().toString();
            if(err == "認証成功"){

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void start(){

    }
}