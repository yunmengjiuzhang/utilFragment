package wangfei.util;

import android.app.Application;

public class BaseApp extends Application {
    private static BaseApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }
}
