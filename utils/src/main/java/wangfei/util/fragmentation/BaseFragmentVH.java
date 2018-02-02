package wangfei.util.fragmentation;

import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;

public class BaseFragmentVH {

    public SupportFragment mCtx;

    public BaseFragmentVH(SupportFragment ctx) {
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.pop();
    }
}
