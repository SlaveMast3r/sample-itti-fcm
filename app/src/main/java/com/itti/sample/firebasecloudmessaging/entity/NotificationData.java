package com.itti.sample.firebasecloudmessaging.entity;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Tomas on 22/02/17.
 */

public class NotificationData extends RealmObject {
    private Date received;
    private String notification;
    private String data;

    public NotificationData() {
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
