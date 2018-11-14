package cn.com.hwtc.aidlserver.application;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import cn.com.hwtc.aidlserver.service.CalculateService;

/**
 * user:Created by jid on 2018/11/14 13:51:09.
 * email:18571762595@163.com.
 */
public class AidlServerApplication extends Application {
    private static final String TAG = "AidlServer " + AidlServerApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        startService(new Intent(this, CalculateService.class));
    }
}
