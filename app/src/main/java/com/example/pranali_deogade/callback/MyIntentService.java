package com.example.pranali_deogade.callback;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by pranali_deogade on 06-12-2017.
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ResultReceiver resultReceiver=intent.getParcelableExtra("receiverTag");
        String name=intent.getStringExtra("nameTag");
        Log.d("pran","received name"+name);
        Log.d("pran","sending data back to activity");
        Bundle bundle=new Bundle();
        bundle.putString("serviceTag","amo");
        resultReceiver.send(1,bundle);


    }


}
