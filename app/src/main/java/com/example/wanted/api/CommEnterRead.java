package com.example.wanted.api;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanted.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CommEnterRead extends AppCompatActivity {

    private TextView textView;
    EditText edit_text_key;
    private ListView lstv;
    private ArrayAdapter<Test> adapter;
    private CreateUserDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DB作成
        helper = new CreateUserDB(getApplicationContext());

        // 変数textViewに表示するテキストビューのidを格納
        textView = findViewById(R.id.text_view);

        //　リストidを格納
        lstv = (ListView) findViewById(R.id.listArea);
        //Test中のtoStringとlist_viewとの結び付け
        adapter = new ArrayAdapter<Test>
                (this, R.layout.list_view, R.id.txtout);
        //リストにセットする
        lstv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "1801203@s.asojuku.ac.jp";
                try {
                    new Http(CommEnterRead.this).execute(new URL("http://ec2-52-91-210-202.compute-1.amazonaws.com/Mail2/mail?mail="+str));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * データベースを読み込む
     * ListAreaに表示
     */
    public void readData(View view){
        ArrayList<Test> psList = new ArrayList<Test>();
        SQLiteDatabase db = helper.getReadableDatabase();

        //Intent intent = new Intent(getApplication(), CommEnterRead.class);
        //startActivity(intent);

        Cursor cursor = db.query(
                "user",
                new String[] { "user_name", "user_id","user_mail","user_department","user_sex","user_icon","user_introduction","user_flag"},
                null,
                null,
                null,
                null,
                null

        );

        cursor.moveToFirst();



        for (int i = 0; i < cursor.getCount(); i++) {
            String str = cursor.getString(0)+" : "+cursor.getString(1)+"点"+"\n"+cursor.getString(2)+cursor.getString(3)+cursor.getString(4)+cursor.getString(5)+cursor.getString(6)+cursor.getString(7);
            cursor.moveToNext();
            Test list = new Test(str);
            adapter.add(list);
        }
        cursor.close();
    }
    /**
     * データベースにデータを保存
     */
    public void saveData(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        EditText editTextTitle = findViewById(R.id.edit_text_key);
        EditText editTextScore = findViewById(R.id.edit_text_value);
        String title = editTextTitle.getText().toString();
        String score = editTextScore.getText().toString();
        values.put("user_name", title);
        values.put("user_mail", score);

        String str = title+ ":" +score;

        db.insert("user", null, values);
        Test list = new Test(str);
        adapter.add(list);
    }
    /**
    画面遷移例
     */
  /*  public void login(View view){

        SpannableStringBuilder sb = (SpannableStringBuilder)edit_text_key.getText();
        String str = "1801190@s.asojuku.ac.jp";
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://52.91.210.202/Mail2/mail?mail="+str));

        startActivity(intent);
    }

    /**
     * 削除対象の日付取得
     */
    public String delteDate() {
        Date date = new Date();

        Calendar day = Calendar.getInstance();
        day.setTime(date);

        day.add(Calendar.MONTH , -1);
        date = day.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(date);
    }

    /**
     * 本日の日付取得
     */
    public String nowDate(){
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(today);
    }

    /**
     * テーブルデータを削除
     */
     public void delete(View v){
         SQLiteDatabase db = helper.getWritableDatabase();
         String now = delteDate();

//       db.delete("testdb","_id = ? AND date = ?",new String[]{"1",now});// 複数指定する場合
         db.delete("user","date < ?",new String[]{now});
    }

    /**
     * 携帯内のデータベース削除
     */
    public void DBdelete(View v){
        deleteDatabase("User.db");
     }
}