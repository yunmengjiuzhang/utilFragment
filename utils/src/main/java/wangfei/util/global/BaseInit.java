package wangfei.util.global;

import wangfei.util.ceshi.CrashHandler;
import wangfei.util.ceshi.LogUtils;

public class BaseInit {
    public void initAll(boolean isDebug) {
        CrashHandler.getInstance().init(BaseApp.getInstance(), "crashfilename");
        LogUtils.init(isDebug, "wangfei");
        SpUtil.init("config");
    }
}
