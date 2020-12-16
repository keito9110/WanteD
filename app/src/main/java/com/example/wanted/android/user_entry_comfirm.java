package com.example.wanted.android;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanted.R;

import java.io.FileDescriptor;
import java.io.IOException;

public class user_entry_comfirm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_registration_confirmation);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        String Student_number = intent.getStringExtra("Student_number");
        String Password = intent.getStringExtra("Password");
        String Department = intent.getStringExtra("Department");
        String Sex = intent.getStringExtra("Sex");

        Uri uri = intent.getParcelableExtra("Uri");
        Bitmap bmp = null;
        try {
            bmp = getBitmapFromUri(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //画像を正方形にする
        int width = bmp.getWidth();
        int height = bmp.getHeight();

        if(width > height){
            bmp = Bitmap.createBitmap(bmp, width / 2 - height / 2, 0, height, height);
        }else{
            bmp = Bitmap.createBitmap(bmp,0, height / 2 - width / 2, width, width);
        }

        String profile = "初期プロフィール";

        ImageView confIcon = (ImageView)findViewById(R.id.confIcon);
        confIcon.setImageBitmap(bmp);
        confIcon.setScaleX(0.5f);
        confIcon.setScaleY(0.5f);

        TextView name = (TextView)findViewById(R.id.txtName);
        name.setText(Name);

        TextView student_number = (TextView)findViewById(R.id.txtStudent_number);
        student_number.setText(Student_number);

        TextView password = (TextView)findViewById(R.id.txtPassword);
        password.setText(Password);

        TextView department = (TextView)findViewById(R.id.txtDepartment);
        department.setText(Department);

        TextView sex = findViewById(R.id.txtSex);
        sex.setText(Sex);
    }

    protected  void onResume(){
        super.onResume();
        Button btnRegistration = (Button)findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //メールアドレスを送る
                //データをアプリ内に保存

            }
        });
    }


    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}
