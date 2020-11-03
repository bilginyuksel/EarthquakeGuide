package com.bilginyuksel.earthquake;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MediaControllerServiceImpl implements MediaControllerService {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    public MediaControllerServiceImpl(Context context) {
        mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public void start(){
        startAlarm(0);
    }

    @Override
    public void start(int timeout){
        startAlarm(timeout);
    }

    @Override
    public void stop() {

    }

    private void startAlarm(int timeout){
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }


    private void setPhoneVolumeToMax() {

    }

}
