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
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * FooService class is used to debug the behavior of Service
 */
public class FooService extends Service {
    private static final String TAG = FooService.class.getSimpleName();
    public static final String ACTION_START_SERVICE = "ACTION_START_SERVICE";

    /**
     *
     * @param intent The Intent supplied to {@link android.content.Context#startService},
     * as given.  This may be null if the service is being restarted after
     * its process has gone away, and it had previously returned anything
     * except {@link #START_STICKY_COMPATIBILITY}.
     * @param flags Additional data about this start request.  Currently either
     * 0, {@link #START_FLAG_REDELIVERY}, or {@link #START_FLAG_RETRY}.
     * @param startId A unique integer representing this specific request to
     * start.  Use with {@link #stopSelfResult(int)}.
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getAction() == ACTION_START_SERVICE){
            Log.wtf(TAG, "This is Service");

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            PendingIntent fooPendingIntent = PendingIntent.getService(
                    this,
                    0,
                    new Intent(ACTION_START_SERVICE, null, getApplicationContext(), FooService.class),
                    0);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 2 * 60 * 1000, fooPendingIntent);
        }
        return START_NOT_STICKY;
    }

    /**
     * Return the communication channel to the service.  May return null if
     * clients can not bind to the service.  The returned
     * {@link IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/components/aidl.html">described using
     * aidl</a>.
     * <p/>
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     *
     * @param intent The Intent that was used to bind to this service,
     *               as given to {@link Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * @return Return an IBinder through which clients can call on to the
     * service.
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
