package wangfei.util.fragmentations;

import android.view.View;

public abstract class BaseAVH {
    public BaseA mCtx;

    public BaseAVH(BaseA ctx) {
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.onBackPressed();
    }

    public void finish() {
        mCtx.finish();
    }
}
