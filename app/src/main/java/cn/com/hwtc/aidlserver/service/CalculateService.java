package cn.com.hwtc.aidlserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import cn.com.hwtc.aidlserver.CalculateInterface;
import cn.com.hwtc.aidlserver.utils.Calculate;

/**
 * user:Created by jid on 2018/8/23 13:31:31.
 * email:18571762595@163.com.
 */
public class CalculateService extends Service {
    private static final String TAG = "AidlServer " + CalculateService.class.getSimpleName();
    private Calculate mCalculate = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        //client调用bindService时此service被启动
        if (null == mCalculate) {
            mCalculate = Calculate.getInstance();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        //START_STICKY:service被杀死后会重启
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    private IBinder mIBinder = new CalculateInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                               double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int doCalculateAdd(int x, int y) throws RemoteException {
            if (null == mCalculate) {
                return 0;
            }
            return mCalculate.calculateAdd(x, y);
        }

        @Override
        public int doCalculateSubtract(int x, int y) throws RemoteException {
            if (null == mCalculate) {
                return 0;
            }
            return mCalculate.calculateSubtract(x, y);
        }

        @Override
        public int doCalculateMultiply(int x, int y) throws RemoteException {
            if (null == mCalculate) {
                return 0;
            }
            return mCalculate.calculateMultiply(x, y);
        }
    };
}
