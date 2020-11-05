package com.bilginyuksel.earthquake.remote;

public abstract class RemoteCommand {
    public static RemoteCommand findRequestedCommand(String command){
        return null;
    }
    public abstract void execute();
}
