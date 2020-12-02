package com.example.wanted.session;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.example.wanted.api.CreateUserDB;
import com.example.wanted.api.Test;

public class user extends Application {

    private CreateUserDB helper;

    private String user_name;
    private String user_id;
    private String user_mail;


    @Override
    public void onCreate() {
        helper = new CreateUserDB(getApplicationContext());
        super.onCreate();
    }
    public void user(){
        helper = new CreateUserDB(getApplicationContext());

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(
                "user",
                new String[] { "user_name", "user_id","user_mail",},
                null,
                null,
                null,
                null,
                null

        );

        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            user user = new user();
            user.setUser_name(cursor.getString(0));
            user.setUser_id(cursor.getString(1));
            user.setUser_mail(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
    }
    public void new_user(SQLiteDatabase db,ContentValues list){
        ContentValues values = new ContentValues();

        values.put("user_name", (String) list.get("user_name"));
        values.put("user_mail", (String) list.get("user_mail"));
        values.put("user_department" , (String) list.get("user_department"));
        values.put("user_icon" , (String)list.get("user_icon"));
        values.put("user_introduction" , (String)list.get("user_introduction"));
        values.put("user_flag" , (String)list.get("user_flag"));

        // values.put("title", title);
        // values.put("score", score);
        // values.put("date", date);

        db.insert("user", null, values);
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
