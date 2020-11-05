package com.bilginyuksel.earthquake.receiver;

import android.util.Log;

import androidx.annotation.NonNull;

import com.bilginyuksel.earthquake.remote.RemoteCommand;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingReceiver extends FirebaseMessagingService {
    private static final String TAG = FirebaseMessagingReceiver.class.getSimpleName();
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "onMessageReceived: " + remoteMessage.getFrom());
        String commandType = null;
        RemoteCommand requestedCommand = RemoteCommand.findRequestedCommand(commandType);
        requestedCommand.execute();
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d(TAG, "onNewToken: " + s);
    }
}
