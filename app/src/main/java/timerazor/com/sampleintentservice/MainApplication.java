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

import android.app.Application;
import android.content.Intent;

public class MainApplication extends Application {
    public static final String TAG = "MainApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(FooIntentService.ACTION_START_INTENT_SERVICE, null, getApplicationContext(), FooIntentService.class));
        startService(new Intent(FooService.ACTION_START_SERVICE, null, getApplicationContext(), FooService.class));
    }
}
