package com.bilginyuksel.earthquake.remote;

import android.content.Context;
import android.location.LocationManager;

public class RemoteLocationControl {
    private Context context;


    public RemoteLocationControl(){
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }
}
