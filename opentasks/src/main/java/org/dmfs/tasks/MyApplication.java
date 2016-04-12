package org.dmfs.tasks;

import android.app.Application;
import com.cmcm.adsdk.CMAdManager;

/**
 * Created by zy on 4/6/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CMAdManager.applicationInit(this, "1362", "");

        CMAdManager.enableLog();
    }
}
