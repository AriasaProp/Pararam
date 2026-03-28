package com.ariasaproject.pararam;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

import java.io.File;
import javax.inject.Inject;
import java.lang.StringBuilder;
import java.lang.String;

public class MainApplication extends Application, Thread.UncaughtExceptionHandler {

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManagerWrapper.createNotificationChannel(
                channelId = AndroidNotificationManagerWrapper.CHANNEL_ID,
                name = getString(R.string.app_name),
                importance = NotificationManager.IMPORTANCE_DEFAULT,
            );
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    
}
