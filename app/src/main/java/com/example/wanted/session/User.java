package com.example.wanted.session;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wanted.api.CreateUserDB;

public class User extends Application {

    private CreateUserDB helper;

    private String user_name;
    private String user_id;
    private String user_mail;
    private String user_dept;
    private String user_icon;
    private String user_intro;
    private String user_flag;


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
            User user = new User();
            user.setUser_name(cursor.getString(0));
            user.setUser_id(cursor.getString(1));
            user.setUser_mail(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
    }
    public void new_user(SQLiteDatabase db,ContentValues list){
        ContentValues values = new ContentValues();

        values.put("user_name", getUser_name());
        values.put("user_mail", getUser_mail());
        values.put("user_department" , getUser_dept());
        values.put("user_icon" , getUser_icon());
        values.put("user_introduction" , getUser_intro());
        values.put("user_flag" , getUser_flag());

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

    public String getUser_dept() {
        return user_dept;
    }

    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    public String getUser_intro() {
        return user_intro;
    }

    public void setUser_intro(String user_intro) {
        this.user_intro = user_intro;
    }

    public String getUser_flag() {
        return user_flag;
    }

    public void setUser_flag() {
        this.user_flag = "0";
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }
}
