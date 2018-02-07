package wangfei.util.fragmentation;

import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;

public class BaseFragmentVH {

    public BaseFragment mCtx;

    public BaseFragmentVH(BaseFragment ctx) {
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.pop();
    }
}
