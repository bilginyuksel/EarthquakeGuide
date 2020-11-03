package com.bilginyuksel.earthquake.remote;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class RemoteSoundControl {
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;
    private final Context context;

    public RemoteSoundControl(Context context){
        this.context = context;
    }

    public void start() {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent  = new Intent(context, MakeSoundCommandReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+1000, alarmIntent);
    }
}
