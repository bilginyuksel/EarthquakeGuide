package com.bilginyuksel.earthquake.remote;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.bilginyuksel.earthquake.receiver.SOSAlarmReceiver;

public class MakeSoundRemoteCommand extends RemoteCommand{
    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;
    private final Context context;

    public MakeSoundRemoteCommand(Context context){
        this.context = context;
    }

    @Override
    public void execute() {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent  = new Intent(context, SOSAlarmReceiver.class);
        intent.putExtra("timeout", 1000);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+1000, alarmIntent);
    }
}
