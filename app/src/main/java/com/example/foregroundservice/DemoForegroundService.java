package com.example.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class DemoForegroundService extends Service {

    public static final String CHANNEL_ID = "ForegroundServiceChannel";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showOnGoingServiceNotification();
        return START_STICKY;

    }

    private void showOnGoingServiceNotification() {

        createNotificationChannel();

        Notification notificationCompat = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("ForegoroundService")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("This is foregorund service")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        startForeground(1, notificationCompat);

    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Foreground service Channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
    }
}
