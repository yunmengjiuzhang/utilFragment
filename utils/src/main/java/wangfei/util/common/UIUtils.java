package wangfei.util.common;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import wangfei.util.BaseApp;

/**
 * 主要用于上下问的获取,资源文件的获得,数组的获得
 */
public class UIUtils {
    /**
     * @param id 资源id
     * @return 获取字符串数组
     */
    public static String[] getStringArray(int id) {
        return getResources().getStringArray(id);
    }

    /**
     * @return 获取Resources对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * @return 获取上下文对象
     */
    public static Application getContext() {
        return BaseApp.getInstance();
    }

    /**
     * @param id
     * @return xml --->View对象
     */
    public static View inflate(int id) {
        return View.inflate(UIUtils.getContext(), id, null);
    }

    /**
     *
     * @param id
     * @return 获取dimens
     */
    public static int getDimens(int id) {
        return getResources().getDimensionPixelSize(id);
    }

//    /**
//     * 启动新的Activity
//     *
//     * @param intent
//     */
//    public static void startActivity(Intent intent) {
//        if (BaseActivity.mCtx == null) {
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//指定任务栈
//            getContext().startActivity(intent);
//        } else {
//            //不需要指定任务栈
//            BaseActivity.mCtx.startActivity(intent);
//        }
////        BaseActivity.mCtx.overridePendingTransition(R.anim.open_fade_in, R.anim.open_fade_out);
//    }    /**

    /**
     * id --- >string
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return getResources().getString(id);
    }

    /**
     * id_---->Drawable
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(int id) {
        return getResources().getDrawable(id);
    }
}
