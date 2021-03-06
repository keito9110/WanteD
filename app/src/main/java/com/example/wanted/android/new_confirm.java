package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wanted.R;
import com.example.wanted.async.Http;
import com.example.wanted.session.User;

import java.net.MalformedURLException;
import java.net.URL;

public class new_confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_registration_confirmation);
    }
    protected void onResume() {
        super.onResume();
    }

    public void new_registration(View v){
        User user = new User();
        String str = user.getUser_mail();
        try {
            new Http(new_confirm.this)
                    .execute(new URL("http://ec2-52-91-210-202.compute-1.amazonaws.com/Mail2/mail2?mail="+str));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(new_confirm.this,com.example.wanted.android.login.class);
        startActivity(intent);
    }
    public void back_registration(View v){
        Intent intent = new Intent(com.example.wanted.android.new_confirm.this,com.example.wanted.android.registration.class);
        startActivity(intent);
    }
}