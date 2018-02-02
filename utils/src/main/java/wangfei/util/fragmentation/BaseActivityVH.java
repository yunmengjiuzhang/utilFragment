package wangfei.util.fragmentation;

import android.view.View;

public abstract class BaseActivityVH {
    public BaseActivity mCtx;

    public BaseActivityVH(BaseActivity ctx) {
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.onBackPressed();
    }

    public void finish() {
        mCtx.finish();
    }
}
