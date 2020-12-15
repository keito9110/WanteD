package com.example.wanted.session;

import android.app.Application;

public class ChatDao extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    private String chat_id;
    private String comm_id;
    private String user_id;
    private String chat_contents;
    private String send_time;

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getComm_id() {
        return comm_id;
    }

    public void setComm_id(String comm_id) {
        this.comm_id = comm_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChat_contents() {
        return chat_contents;
    }

    public void setChat_contents(String chat_contents) {
        this.chat_contents = chat_contents;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }
}
