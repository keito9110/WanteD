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

    private static final String TABLE_EVENT_CHAT = "event_chat";
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
    private static final String TABLE_NOTIFICATION = "notification";
    private static final String TABLE_TITLE = "title";
    private static final String TABLE_EVENT = "event_notification";
    private static final String EVENT_ID = "event_id";
    private static final String DATE = "expiration_date";
    private static final String EVENT_CHAT_ID = "event_chat_id";
    private static final String CHAT_ID = "chat_id";
    private static final String CHAT_CONTENTS = "chat_contents";
    private static final String SEND_TIME = "send_time";
    private static final String COMM_ID = "community_id";
    private static final String NOTIFICATION_ID = "notification_id";
    private static final String TITLE_ID = "title_id";
    private static final String TITLE_NAME = "title_name";
    private static final String SENDER_ID = "sender_id";

    private static final String SQL_CREATE_EVENT =
            "CREATE TABLE " + TABLE_EVENT + " (" +
                    EVENT_ID + " INTEGER PRIMARY KEY," +
                    DATE + " TEXT )";

    private static final String SQL_CREATE_EVENT_CHAT =
            "CREATE TABLE " + TABLE_EVENT_CHAT + " (" +
                    EVENT_CHAT_ID + " INTEGER PRIMARY KEY," +
                    EVENT_ID + " TEXT, " +
                    USER_ID + " TEXT, " +
                    CHAT_CONTENTS + "TEXT, " +
                    SEND_TIME + " TEXT)";

    private static final String SQL_CREATE_CHAT =
            "CREATE TABLE " + TABLE_CHAT + " (" +
                    CHAT_ID + " INTEGER PRIMARY KEY," +
                    COMM_ID + " TEXT, " +
                    USER_ID + " TEXT, " +
                    CHAT_CONTENTS + "TEXT, " +
                    SEND_TIME + " TEXT)";

    private static final String SQL_CREATE_NOTIFICATION =
            "CREATE TABLE " + TABLE_NOTIFICATION + " (" +
                    NOTIFICATION_ID + " INTEGER PRIMARY KEY," +
                    SENDER_ID + " TEXT, " +
                    COMM_ID + " TEXT, " +
                    DATE + "TEXT, " +
                    SEND_TIME + " TEXT)";

    private static final String SQL_CREATE_TITLE =
            "CREATE TABLE " + TABLE_TITLE + " (" +
                    TITLE_ID + " INTEGER PRIMARY KEY," +
                    TITLE_NAME +  "TEXT)";

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



    CreateUserDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                SQL_CREATE_USER
        );
        db.execSQL(
                SQL_CREATE_TITLE
        );
        db.execSQL(
                SQL_CREATE_NOTIFICATION
        );
        db.execSQL(
                SQL_CREATE_EVENT
        );
        db.execSQL(
                SQL_CREATE_EVENT_CHAT
        );
        saveData(db,"m","k");

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

        values.put("user_name", title);
        values.put("user_mail", score);

       // values.put("title", title);
       // values.put("score", score);
       // values.put("date", date);

        db.insert("user", null, values);
    }
}