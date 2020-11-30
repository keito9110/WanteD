package com.example.wanted;

import java.util.Date;

public class Test {
    private StringBuilder text;
    private String text2;
    private Date day;

    public Test(String str){
        this.text2=str;
    }

    public Test(StringBuilder str) {
        this.text=str;
    }

    public String toString() {
        return text2;
    }
    public void Day(Date day){
        this.day = day;
    }
    public Date today(){
        return day;
    }

}
