package wangfei.util.common;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import wangfei.util.BaseApp;

/**
 * wf
 * 主要用于上下问的获取,资源文件的获得,数组的获得
 */
public class UIUtils {
    /**
     * 根据资源id 获取字符串数组
     *
     * @param id
     * @return
     */
    public static String[] getStringArray(int id) {
        return getResources().getStringArray(id);
    }

    /**
     * 获取Resources对象
     *
     * @return
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取上下文对象
     *
     * @return
     */
    public static Application getContext() {
        return BaseApp.getInstance();
    }

    /**
     * xml --->View对象
     *
     * @param id
     * @return
     */
    public static View inflate(int id) {
        return View.inflate(UIUtils.getContext(), id, null);
    }

    /**
     * 获取dimens
     *
     * @param id
     * @return
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
