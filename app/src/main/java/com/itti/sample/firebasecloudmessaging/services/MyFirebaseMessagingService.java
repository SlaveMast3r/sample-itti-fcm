package com.itti.sample.firebasecloudmessaging.services;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.itti.sample.firebasecloudmessaging.R;
import com.itti.sample.firebasecloudmessaging.entity.NotificationData;

import java.util.Date;

import io.realm.Realm;

/**
 * Created by Tomas on 19/02/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingServ";

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        try {
            NotificationData notification = realm.createObject(NotificationData.class);
            notification.setReceived(new Date());

            // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
            Log.d(TAG, "From: " + remoteMessage.getFrom());

            // Check if message contains a data payload.
            if (remoteMessage.getData().size() > 0) {
                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                notification.setData(remoteMessage.getData().toString());
            }

            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
                notification.setNotification(getString(R.string.notification_fmt,
                        remoteMessage.getNotification().getBody()));
            }

            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }
}