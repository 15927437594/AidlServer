package cn.com.hwtc.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * user:Created by jid on 2018/8/23 13:31:31.
 * email:18571762595@163.com.
 */
public class CalculateService extends Service {

    private Calculate calculate = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (calculate == null) {
            calculate = Calculate.getInstance();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    private IBinder mIBinder = new CalculateInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int doCalculateAdd(int x, int y) throws RemoteException {
            assert calculate != null;
            return calculate.calculateAdd(x, y);
        }

        @Override
        public int doCalculateSubtract(int x, int y) throws RemoteException {
            assert calculate != null;
            return calculate.calculateSubtract(x, y);
        }

        @Override
        public int doCalculateMultiply(int x, int y) throws RemoteException {
            assert calculate!=null;
            return calculate.calculateMultiply(x,y);
        }
    };
}
