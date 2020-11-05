package com.bilginyuksel.earthquake.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;


public class SOSAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mediaPlayer = prepareMediaPlayerForSOSCall(context);
        HelpCallThread helpCallThread = new HelpCallThread(mediaPlayer, intent.getExtras().getInt("timeout", 3000));
        helpCallThread.run();
    }

    private MediaPlayer prepareMediaPlayerForSOSCall(Context context){
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1.0f, 1.0f);
        return mediaPlayer;
    }

    public static class HelpCallThread implements Runnable {

        private int timeout;
        private MediaPlayer mediaPlayer;
        HelpCallThread(MediaPlayer mediaPlayer, int timeout){
            this.timeout = timeout;
            this.mediaPlayer = mediaPlayer;
        }

        @Override
        public void run() {
            try {
                mediaPlayer.start();
                Thread.sleep(timeout);
                mediaPlayer.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
