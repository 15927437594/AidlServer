package cn.com.hwtc.aidlserver;

/**
 * user:Created by jid on 2018/8/23 13:36:34.
 * email:18571762595@163.com.
 */
public class Calculate {
    private static Calculate sInstance = null;

    private Calculate() {

    }

    public static Calculate getInstance() {
        if (null == sInstance) {
            synchronized (Calculate.class) {
                if (null == sInstance) {
                    sInstance = new Calculate();
                }
            }
        }
        return sInstance;
    }

    public int calculateAdd(int x, int y) {
        return x + y;
    }

    public int calculateSubtract(int x, int y) {
        return x - y;
    }

    public int calculateMultiply(int x, int y) {
        return x * y;
    }
}
