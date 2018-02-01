package wangfei.util.common;

import android.os.Handler;


/**
 * wf
 * 1. 子线程执行方法
 * 2. 切换到主线程
 */
public class ThreadUtils {

    /**
     * 在子线程执行
     *
     * @param runnable
     */
    public static void runOnBackThread(Runnable runnable) {
//        new Thread(runnable).start();   // 线程池
        ThreadPoolManager.getInstance().createThreadPool().execture(runnable);
    }

    private static Handler handler = new Handler();

    /**
     * 在主线程执行
     *
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }

    /**
     * 在主线程执行
     *
     * @param runnable
     */
    public static void runOnUiThreadDelayed(Runnable runnable, int a) {
        handler.postDelayed(runnable, a);
    }
}
