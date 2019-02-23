package com.angran.dushu.angranmall;

import android.app.Application;

/**
 * author: Create By dushu on 2019/2/9 14:48
 * email : dushu@bytedance.com
 */
public class ARApplication extends Application {

    private static final String TAG = "ARApplication";
    private static ARApplication sApplication;

    public static ARApplication getInst() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}
