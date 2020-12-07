package com.example.wanted.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wanted.R;
import com.example.wanted.session.User;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }


    public void back_login(View v) {
        Intent intent = new Intent(com.example.wanted.android.registration.this,com.example.wanted.android.login.class);
        startActivity(intent);
    }
    public void confirm(View v){
        EditText editName = findViewById(R.id.editTextTextPersonName6);
        EditText editId = findViewById(R.id.editTextTextPersonName7);
        EditText editPass = findViewById(R.id.editTextTextPersonName8);
        EditText editDept = findViewById(R.id.editTextTextPersonName9);

        String name = editName.getText().toString();
        String id = editId.getText().toString();
        String pass = editPass.getText().toString();
        String dept = editDept.getText().toString();
        String mail = id + "@s.asojuku.ac.jp";

        User user = new User();
        user.setUser_id(id);
        user.setUser_flag();
        user.setUser_name(name);
        user.setUser_dept(dept);
        user.setUser_mail(mail);

        Intent intent = new Intent(com.example.wanted.android.registration.this,com.example.wanted.android.new_confirm.class);
        startActivity(intent);
    }
}