package com.bilginyuksel.earthquake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bilginyuksel.earthquake.remote.RemoteCommand;

public class MainActivity extends AppCompatActivity {

    private Button btnTest;

    private void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION
                        , Manifest.permission.ACCESS_FINE_LOCATION}, 1500);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestLocationPermission();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        btnTest = findViewById(R.id.btn_test);
        final AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                RemoteCommand remoteSoundControl = RemoteCommand.findRequestedCommand(getApplicationContext(), "make_sound");
                remoteSoundControl.execute();
            }
        });

    }
}
