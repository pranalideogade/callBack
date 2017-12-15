package com.example.pranali_deogade.callback;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by pranali_deogade on 06-12-2017.
 */

public class MyResultReceiver extends ResultReceiver {
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    private Receiver mReceiver;

    public MyResultReceiver(Handler handler) {
        super(handler);
    }

    public void setmReceiver(Receiver mReceiver) {
        this.mReceiver = mReceiver;
    }

    public interface Receiver {
        public  void onReceiveResult(int resultCode, Bundle resultData);
    }



    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (mReceiver!=null) {
            mReceiver.onReceiveResult(resultCode, resultData);
        }
    }
}
