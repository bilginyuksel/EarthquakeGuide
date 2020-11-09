package com.bilginyuksel.earthquake.remote;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

public class GetLocationRemoteCommand extends RemoteCommand {
    private static final String TAG = GetLocationRemoteCommand.class.getSimpleName();
    private final LocationManager locationManager;
    private final Context context;

    public GetLocationRemoteCommand(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Log.i(TAG, "GetLocationRemoteCommand: constructor" );
    }


    private boolean checkLocationPermission() {
        boolean accessFineLocation = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean accessCoarseLocation = ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        return accessCoarseLocation && accessFineLocation;
    }

    @Override
    public void execute() {
        Log.i(TAG, "execute: ");
        if (!checkLocationPermission()) return;
        Log.i(TAG, "after execute: ");
        boolean hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Location gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (hasGps) Log.i(TAG, "gps: " + gpsLocation.toString());
        if (hasNetwork) Log.i(TAG, "network: " + networkLocation.toString());
    }
}
