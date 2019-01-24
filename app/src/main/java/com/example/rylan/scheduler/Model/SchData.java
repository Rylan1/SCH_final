package com.example.rylan.scheduler.Model;

import java.util.Date;

import io.realm.RealmObject;

public class SchData extends RealmObject {
    private String topic;
    private String date1;
    private Date daa;
    private Date date2;
    public SchData(){}

    public SchData(String topic, String date, Date daa, Date date2) {

        this.topic = topic;
        this.date1 = date;
        this.daa = daa;
        this.date2 = date2;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }



    public String getDate1() {
        return date1;
    }

    public void setDate1(String date) {
        this.date1 = date;
    }

    public Date getDaa() {
        return daa;
    }

    public void setDaa(Date daa) {
        this.daa = daa;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
}

