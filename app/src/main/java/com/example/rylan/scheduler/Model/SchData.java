package com.example.rylan.scheduler.Model;

import java.util.Date;

import io.realm.RealmObject;

public class SchData extends RealmObject {
    private String topic;

    private Date daa;
    private Date date2;
    public SchData(){}

    public SchData(String topic, Date daa, Date date2) {

        this.topic = topic;

        this.daa = daa;
        this.date2 = date2;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

