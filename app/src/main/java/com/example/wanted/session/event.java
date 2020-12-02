package com.example.wanted.session;

import android.app.Application;
import android.widget.ArrayAdapter;

import java.util.Date;

public class event extends Application {

    private String event_id;
    private String event_name;
    private String event_date_before;
    private String event_date_after;
    private String event_stage;
    private String event_member;
    private String event_syousai;
    private String event_point_1;
    private String event_point_2;
    private String event_point_3;
    private ArrayAdapter<String> adapter;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ArrayAdapter<String> getEvent() {
        ArrayAdapter<String> ev_list = adapter;

        return ev_list;
    }

    public void setEvent(ArrayAdapter<String> ev_list) {
        ev_list.add(getEvent_name());
        ev_list.add(getEvent_date_before());
        ev_list.add(getEvent_date_after());
        ev_list.add(getEvent_stage());
        ev_list.add(getEvent_member());
        ev_list.add(getEvent_syousai());
        ev_list.add(getEvent_point_1());
        ev_list.add(getEvent_point_2());
        ev_list.add(getEvent_point_3());
        adapter = ev_list;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_date_before() {
        return event_date_before;
    }

    public void setEvent_date_before(String event_date_before) {
        this.event_date_before = event_date_before;
    }

    public String getEvent_date_after() {
        return event_date_after;
    }

    public void setEvent_date_after(String event_date_after) {
        this.event_date_after = event_date_after;
    }

    public String getEvent_stage() {
        return event_stage;
    }

    public void setEvent_stage(String event_stage) {
        this.event_stage = event_stage;
    }

    public String getEvent_member() {
        return event_member;
    }

    public void setEvent_member(String event_member) {
        this.event_member = event_member;
    }

    public String getEvent_syousai() {
        return event_syousai;
    }

    public void setEvent_syousai(String event_syousai) {
        this.event_syousai = event_syousai;
    }

    public String getEvent_point_1() {
        return event_point_1;
    }

    public void setEvent_point_1(String event_point_1) {
        this.event_point_1 = event_point_1;
    }

    public String getEvent_point_2() {
        return event_point_2;
    }

    public void setEvent_point_2(String event_point_2) {
        this.event_point_2 = event_point_2;
    }

    public String getEvent_point_3() {
        return event_point_3;
    }

    public void setEvent_point_3(String event_point_3) {
        this.event_point_3 = event_point_3;
    }
}