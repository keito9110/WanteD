package com.example.wanted.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by kuwahara on 2018/09/24.
 * 参考：https://akira-watson.com/android/sqlite.html
 */
public class CreateUserDB extends SQLiteOpenHelper {

    // データーベースのバージョン
    private static final int DATABASE_VERSION = 3;

    // データーベース情報を変数に格納
//  private static final String CULUM名 = 変数名;
    private static final String DATABASE_NAME = "User.db";

    private static final String TABLE_USER = "user";

    private static final String USER_NAME = "user_name";
    private static final String USER_DEPARTMENT = "user_department";
    private static final String USER_SEX = "user_sex";
    private static final String USER_MAIL = "user_mail";
    private static final String USER_ICON = "user_icon";
    private static final String USER_INTRODUCTION = "user_introduction";
    private static final String USER_FLAG = "user_flag";
    private static final String USER_ID = "user_id";

    private static final String TABLE_CHAT = "chat";
    private static final String CHAT_ID = "chat_id";
    private static final String CHAT_CONTENTS = "chat_contents";
    private static final String SEND_TIME = "send_time";
    private static final String COMM_ID = "community_id";


    private static final String SQL_CREATE_CHAT =
            "CREATE TABLE " + TABLE_CHAT + " (" +
                    CHAT_ID + " INTEGER PRIMARY KEY," +
                    COMM_ID + " TEXT, " +
                    USER_ID + " TEXT, " +
                    CHAT_CONTENTS + "TEXT, " +
                    SEND_TIME + " TEXT)";

   private static final String SQL_CREATE_USER =
           "CREATE TABLE " + TABLE_USER+ " (" +
                   USER_ID + " INTEGER PRIMARY KEY," +
                   USER_NAME + " TEXT," +
                   USER_FLAG + " INTEGER," +
                   USER_ICON + " BLOB," +
                   USER_INTRODUCTION + " TEXT," +
                   USER_DEPARTMENT + " TEXT," +
                   USER_SEX + " TEXT," +
                   USER_MAIL + " TEXT )";

    // 複合主キー 最後にPRIMARY KEY (CULUM名,CULUM名);
    // INTEGER TEXT BLOB NULL REAL SQLlite

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_USER;
    private static final String SQ_DELETE_CHAT =
            "DROP TABLE IF EXISTS " + TABLE_CHAT;




    public CreateUserDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                SQL_CREATE_USER
        );
        db.execSQL(
                SQL_CREATE_CHAT
        );
        saveData(db,"こんにちは",nowDate());
        saveData(db,"よろしくお願いします。",nowDate());


    }

    /**
     * 本日の日付取得
     */
    public String nowDate() {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(today);
    }

    // 参考：https://sankame.github.io/blog/2017-09-05-android_sqlite_db_upgrade/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        db.execSQL(
                SQ_DELETE_CHAT
        );
        onCreate(db);
    }

    //もしデータベースのバージョンが変わった場合データベースを引き継ぐ
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     *　データベースにデータを保存
     * @param title Create時の変数名
     * @param score
     */
    public void saveData(SQLiteDatabase db, String title, String score) {
        ContentValues values = new ContentValues();

        values.put("chat_contents", title);
        values.put("send_time", score);

       // values.put("title", title);
       // values.put("score", score);
       // values.put("date", date);

        db.insert("chat", null, values);
    }
}