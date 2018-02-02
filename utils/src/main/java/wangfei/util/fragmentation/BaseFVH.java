package wangfei.util.fragmentation;

import android.view.View;

public class BaseFVH {

    public BaseF mCtx;

    public BaseFVH(BaseF ctx) {
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.pop();
    }
}
