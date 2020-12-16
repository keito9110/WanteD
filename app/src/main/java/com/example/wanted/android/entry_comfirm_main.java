package com.example.wanted.android;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.wanted.R;

import java.io.FileDescriptor;
import java.io.IOException;
public class entry_comfirm_main extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;
    private Bitmap bmp;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        imageView = (ImageView) findViewById(R.id.imgIcon);
    }


    @Override
    protected void onResume() {

        super.onResume();
        Button btnConfirmation = (Button) findViewById(R.id.btnConfirmation);
        btnConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etxtName = (EditText) findViewById(R.id.etxtName);
                EditText etxtStudent_number = (EditText) findViewById(R.id.etxtStudent_number);
                EditText etxtPassword = (EditText) findViewById(R.id.etxtPassword);
                EditText etxtDepartment = (EditText) findViewById(R.id.etxtDepartment);
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
                // ImageView img = (ImageView)findViewById(R.id.imgIcon);


                String name = etxtName.getText().toString();
                String student = etxtStudent_number.getText().toString();
                String pass = etxtPassword.getText().toString();
                String Deap = etxtDepartment.getText().toString();

                //性別の受け渡し
                int id = rg.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(id);
                String sex = radioButton.getText().toString();


                if (etxtName.length() != 0 && etxtStudent_number.length() != 0 &&
                        etxtPassword.length() != 0 && etxtDepartment.length() != 0 && uri != null && sex != null) {

                    Intent intent = new Intent(entry_comfirm_main.this, user_entry_comfirm.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Password", pass);
                    intent.putExtra("Student_number", student);
                    intent.putExtra("Department", Deap);
                    intent.putExtra("Sex", sex);
                    intent.putExtra("Uri", uri);


                    startActivity(intent);

                } else {

                    Intent intent = new Intent(getApplication(), entry_comfirm_main.class);
                    startActivity(intent);

                }

            }
        });

        //画像追加ボタン押下時処理
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == RESULT_OK) {

            if (resultData != null) {
                uri = resultData.getData();

                try {
                    bmp = getBitmapFromUri(uri);
                    //画像を正方形にする
                    int width = bmp.getWidth();
                    int height = bmp.getHeight();
                    Bitmap croppedBitmap;
                    if (width > height) {
                        croppedBitmap = Bitmap.createBitmap(bmp, width / 2 - height / 2, 0, height, height);
                    } else {
                        croppedBitmap = Bitmap.createBitmap(bmp, 0, height / 2 - width / 2, width, width);
                    }
                    bmp = croppedBitmap;


                    imageView.setScaleX(0.5f);
                    imageView.setScaleY(0.5f);
                    imageView.setImageBitmap(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //URIをビットマップに変換
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}