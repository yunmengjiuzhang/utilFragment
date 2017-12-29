package wangfei.util;

import wangfei.util.BaseApp;
import wangfei.util.ceshi.CrashHandler;
import wangfei.util.ceshi.LogUtils;
import wangfei.util.global.SpUtil;

public class BaseInit {
    public void initAll(boolean isDebug) {
        CrashHandler.getInstance().init(BaseApp.getInstance(), "crashfilename");
        LogUtils.init(isDebug, "wangfei");
        SpUtil.init("config");
    }
}
