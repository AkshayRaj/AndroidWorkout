/**
 * The contents of this file are copyrighted by timeRAZOR, Inc. The contents of
 * this file represents the real and intellectual property of timeRAZOR, Inc.
 * Any source code, configuration parameters, documentation, data or database
 * schema may not be copied, modified, reused or distributed without the written
 * consent of timeRAZOR, Inc.
 * <p/>
 * <p/>
 * Copyright (c) 2014 Gravy. All rights reserved.
 */
package timerazor.com.sampleintentservice;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FooIntentService extends IntentService {
    private static final String TAG = FooIntentService.class.getSimpleName();
    public static final String ACTION_START_INTENT_SERVICE = "ACTION_START_INTENT_SERVICE";

    public FooIntentService(){
        super("Default");

    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public FooIntentService(String name) {
        super(name);
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent.getAction() == ACTION_START_INTENT_SERVICE){
            Log.wtf(TAG, "This is IntentService");

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            PendingIntent fooPendingIntent = PendingIntent.getService(
                    this,
                    0,
                    new Intent(FooIntentService.ACTION_START_INTENT_SERVICE, null, getApplicationContext(), FooIntentService.class),
                    0);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 2 * 60 * 1000, fooPendingIntent);

        }
    }
}
