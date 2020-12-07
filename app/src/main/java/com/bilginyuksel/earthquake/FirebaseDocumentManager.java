package com.bilginyuksel.earthquake;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class FirebaseDocumentManager {
    private static final String TAG = FirebaseDocumentManager.class.getSimpleName();
    private final FirebaseFirestore firestore;

    public FirebaseDocumentManager() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void saveLocationInfo(Map<String, Object> locationData) {
        getQuerySnapshotOfCollection("location").addOnCompleteListener((task)->{
            if(task.isSuccessful()) {
                Log.i(TAG, "saveLocationInfo: ");
                QuerySnapshot queryDocumentSnapshots = task.getResult();
            }
        });
    }

    public void saveUserInfO(Map<String, Object> userInfo) {
        firestore.collection("user");
    }

    public Task<QuerySnapshot> getQuerySnapshotOfCollection(String collection) {
        return firestore.collection(collection).get();
    }

}