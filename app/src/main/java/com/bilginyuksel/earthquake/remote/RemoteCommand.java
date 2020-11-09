package com.bilginyuksel.earthquake.remote;

import android.content.Context;

public abstract class RemoteCommand {
    public static final String GET_LOCATION = "get_location";
    public static final String MAKE_SOUND = "make_sound";
    public static final String COMPUTE_DISTANCE = "compute_distance";

    public static RemoteCommand findRequestedCommand(final Context context, String command) {
        if (command.equals(GET_LOCATION)) return new GetLocationRemoteCommand();
        else if (command.equals(MAKE_SOUND)) return new MakeSoundRemoteCommand(context);
        else if (command.equals(COMPUTE_DISTANCE)) return new ComputeDistanceRemoteCommand();
        return new DefaultRemoteCommand();
    }

    public abstract void execute();
}
