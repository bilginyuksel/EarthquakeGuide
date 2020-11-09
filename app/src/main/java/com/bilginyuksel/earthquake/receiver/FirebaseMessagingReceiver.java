package com.bilginyuksel.earthquake.receiver;

import android.util.Log;

import androidx.annotation.NonNull;

import com.bilginyuksel.earthquake.remote.RemoteCommand;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FirebaseMessagingReceiver extends FirebaseMessagingService {
    private static final String TAG = FirebaseMessagingReceiver.class.getSimpleName();

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i(TAG, "onMessageReceived: Message data= "+ remoteMessage.getData().toString());

        Map<String, String> remoteMessageData = remoteMessage.getData();
        if (remoteMessageData.containsKey("command")) {
            String command = remoteMessageData.get("command");
            RemoteCommand.findRequestedCommand(getApplicationContext(), command)
                    .execute();
            return;
        }

        sendDetailedNotification(remoteMessage);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d(TAG, "onNewToken: " + s);
    }


    public void sendDetailedNotification(RemoteMessage remoteMessage) {
        Log.i(TAG, "sendDetailedNotification: " );
    }

}
