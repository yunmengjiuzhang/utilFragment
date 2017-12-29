//package wangfei.util.global;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.annotation.RequiresApi;
//import android.view.WindowManager;
//
//import com.baidu.mobstat.StatService;
//import com.reformer.myutils.R;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import mutils.views.LoadingDialog;
//import wangfei.swipeback.SwipeBackActivity;
//import wangfei.swipeback.SwipeBackLayout;
//
//public class BaseActivity extends SwipeBackActivity {
//    // 共享资源
//    public static List<BaseActivity> activities = new ArrayList<>();
//    //    public static BaseActivity activity;//当前的Activity
//    public static BaseActivity mCtx;//上下文
//    private LoadingDialog loadingDialog;
//    protected SwipeBackLayout mSwipeBackLayout;
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //添加到集合中统一维护
//        synchronized (activities) {
//            activities.add(mCtx = this);
//        }
//        initBarState();
//        initOnBackTheme();
//        loadingDialog = new LoadingDialog(this);
////        refresh();
//        initViews();
//        initData();
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(byte[] datas) {
//        onDataReceived(datas);
//    }
//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onMessageEventBackground(byte[] datas) {
//        onDataReceivedBackground(datas);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(String message) {
////        ToastUtils.showToast(message);
//        onBleStateListener(message);
//    }
//
//    public void onBleStateListener(String message) {
//    }
//
////    protected void onBleStateListener(String message) {
////        switch (message) {
////            case "211"://ble服务断开
////                showLoadingDialog("连接中...");
////                break;
////            case "203"://连接成功
////                hideLoadingDialog();
////                break;
////            case "212"://连接失败
////                BleUtils.close();
////                hideLoadingDialog();
////                ToastUtils.showToast("连接失败!");
//////                UIUtils.startActivity(new Intent(mCtx, ScanActivity.class));
////                break;
////        }
////    }
//
//    protected void onDataReceived(byte[] bytes) {
//
//    }
//
//    protected void onDataReceivedBackground(byte[] datas) {
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        StatService.onResume(mCtx);
//        mCtx = this;
//        init();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        StatService.onPause(mCtx);
//        mCtx = null;
//        SpUtil.putString("welcomeTime", String.valueOf(System.currentTimeMillis()));
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        synchronized (activities) {
//            activities.remove(this);
//        }
//    }
//
//    public void killAll() {
//        //遍历中不允许增删
//        //1. 复制一份
//        //2. CopyOnWriteArrayList 可以在遍历中做增删操作
//        List<BaseActivity> copy;
//        synchronized (activities) {
//            copy = new ArrayList<>(activities);
//        }
//        for (BaseActivity activity : copy) {
//            activity.finish();
//        }
//
//        //  自杀进程
//        android.os.Process.killProcess(android.os.Process.myPid());
//    }
//
//    /**
//     * 初始化操作
//     */
//    protected void init() {
//    }
//
//    /**
//     * 初始化所有的控件
//     */
//    protected void initViews() {
//
//    }
//
//    /**
//     * 初始化数据
//     */
//    protected void initData() {
//
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        overridePendingTransition(R.anim.close_fade_in, R.anim.close_fade_out);
//    }
//
//    /**
//     * 显示加载对话框
//     */
//    public void showLoadingDialog(String message) {
//        if (loadingDialog != null && !loadingDialog.isShowing()) {
//            if (message == null) {
//                loadingDialog.show();
//            } else {
//                loadingDialog.setMessage(message);
//                loadingDialog.show();
//            }
//            ThreadUtils.runOnUiThreadDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (loadingDialog != null && loadingDialog.isShowing()) {
//                        loadingDialog.dismiss();
//                        finish();
//                        ToastUtils.showToast("连接超时!");
//                    }
//                }
//            }, 4000);
//        }
//    }
//
//    /**
//     * 隐藏加载对话框
//     */
//    public void hideLoadingDialog() {
//        if (loadingDialog != null && loadingDialog.isShowing()) {
//            loadingDialog.dismiss();
//        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    protected void initBarState() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            //透明导航栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
////            getWindow().setNavigationBarColor(Color.TRANSPARENT); //写法一
//        }
//    }
//
//    private void initOnBackTheme() {
//        mSwipeBackLayout = getSwipeBackLayout();
//        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
//    }
//}
