package com.example.rylan.scheduler.Model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.RealmField;
import io.realm.annotations.Required;

public class SchData extends RealmObject {
    @Required
    private String topic;
    @Required
    private Date daa;
    @Required
    private Date date2;


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

