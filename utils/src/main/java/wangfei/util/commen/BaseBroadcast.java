package wangfei.util.commen;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import wangfei.util.commen.UIUtils;

public class BaseBroadcast {

    private LocalBroadcastManager localBroadcastManager = null;
    private BroadcastReceiver mBroadcastReceiver;
    protected String mAction = "com.example.broadcasttest.LOCAL_BROADCAST";


    public BaseBroadcast() {
    }


    public void registerLocalBroadcast(BroadcastReceiver broadcastReceiver) {
        localBroadcastManager = LocalBroadcastManager.getInstance(UIUtils.getContext());//获取实例localBroadcastManager = LocalBroadcastManager.getInstance(this);//获取实例
        mBroadcastReceiver = broadcastReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(mAction);
        localBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);
    }

    public void registerNomalBroadcast(BroadcastReceiver broadcastReceiver) {
        mBroadcastReceiver = broadcastReceiver;
        IntentFilter filter_system = new IntentFilter();
        filter_system.addAction(mAction);
        UIUtils.getContext().registerReceiver(mBroadcastReceiver, filter_system);
    }

    public void send(Intent intent) {
        intent.setAction(mAction);
        if (localBroadcastManager != null)
            localBroadcastManager.sendBroadcast(intent);
        else
            UIUtils.getContext().sendBroadcast(intent);
    }

    public void unregister() {
        if (mBroadcastReceiver != null)
            if (localBroadcastManager != null) {
                localBroadcastManager.unregisterReceiver(mBroadcastReceiver);
            } else {
                UIUtils.getContext().unregisterReceiver(mBroadcastReceiver);
            }
    }
}
