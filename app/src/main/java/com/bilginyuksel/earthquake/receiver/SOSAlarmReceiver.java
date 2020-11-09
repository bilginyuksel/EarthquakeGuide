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
        MediaControlThread mediaControlThread =
                new MediaControlThread(mediaPlayer, intent.getExtras().getInt("timeout", 3000));
        mediaControlThread.run();
    }

    private MediaPlayer prepareMediaPlayerForSOSCall(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1.0f, 1.0f);
        return mediaPlayer;
    }

    public static class MediaControlThread implements Runnable {

        private final int timeout;
        private final MediaPlayer mediaPlayer;

        MediaControlThread(MediaPlayer mediaPlayer, int timeout) {
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
