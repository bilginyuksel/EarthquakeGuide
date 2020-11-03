package com.bilginyuksel.earthquake.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;


public class MakeSoundCommandReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Hello, World");
        HelpCallThread helpCallThread = new HelpCallThread(
                MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI), 3000);
        helpCallThread.run();
    }

    public static class HelpCallThread implements Runnable {

        private int timeout;
        private MediaPlayer mediaPlayer;
        HelpCallThread(MediaPlayer mediaPlayer, int timeout){
            this.timeout = timeout;
            this.mediaPlayer = mediaPlayer;
            this.mediaPlayer.setLooping(true);
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
