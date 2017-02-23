package com.itti.sample.firebasecloudmessaging.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itti.sample.firebasecloudmessaging.R;
import com.itti.sample.firebasecloudmessaging.entity.NotificationData;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by Tomas on 22/02/17.
 */

public class NotificationAdapter extends RealmRecyclerViewAdapter<NotificationData, NotificationAdapter.NotificationHolder> {

    public NotificationAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<NotificationData> data) {
        super(context, data, true);
    }

    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification, parent, false);
        return new NotificationHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, int position) {
        NotificationData notification = getItem(position);
        holder.time.setText(notification != null ? notification.getReceived().toString() : null);
        holder.data.setText(notification != null ? notification.getData() : null);
        holder.notification.setText(notification != null ? notification.getNotification() : null);
    }

    class NotificationHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView notification;
        TextView data;

        NotificationHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.date);
            notification = (TextView) itemView.findViewById(R.id.notification);
            data = (TextView) itemView.findViewById(R.id.data);
        }
    }
}
