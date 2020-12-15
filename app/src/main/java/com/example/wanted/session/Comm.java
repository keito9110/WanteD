package com.example.wanted.session;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

public class Comm extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    private String comm_id;
    private String comm_name;
    private String comm_intro;
    private ArrayList<HashMap<String,String>> list;

    public String getComm_id() {
        return comm_id;
    }

    public void setComm_id(String comm_id) {
        this.comm_id = comm_id;
    }

    public String getComm_name() {
        return comm_name;
    }

    public void setComm_name(String comm_name) {
        this.comm_name = comm_name;
    }

    public String getComm_intro() {
        return comm_intro;
    }

    public void setComm_intro(String comm_intro) {
        this.comm_intro = comm_intro;
    }
    public ArrayList<HashMap<String,String>> getList(){
        return list;
    }
    public void setList(ArrayList<HashMap<String,String>> list){
        this.list = list;
    }
}
