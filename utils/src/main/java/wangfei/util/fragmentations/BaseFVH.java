package wangfei.util.fragmentations;

import android.databinding.ObservableField;
import android.view.View;

import com.reformer.util.R;

import wangfei.util.global.SpUtil;

public class BaseFVH {

    public BaseF mCtx;

    public BaseFVH(BaseF ctx) {
        isYanfa.set(SpUtil.getBoolean("isYanfa", false));
        mCtx = ctx;
    }

    public void onBack(View view) {
        mCtx.pop();
    }


    public final ObservableField<String> title = new ObservableField<>("详情");
    public final ObservableField<String> titleright = new ObservableField<>();
    public final ObservableField<Integer> leftBackgroundId = new ObservableField<>(R.mipmap.left);
    public final ObservableField<Integer> rightBackgroundId = new ObservableField<>(R.mipmap.refresh);
    public final ObservableField<Boolean> isRefresh = new ObservableField<>(false);
    public final ObservableField<Boolean> isOnBackVisible = new ObservableField<>(true);
    public final ObservableField<Boolean> isRefreshVisible = new ObservableField<>(true);

    public final ObservableField<Boolean> isYanfa = new ObservableField<>(false);

    public void onTitleClick(View view) {
    }

    public void onRightClick() {
        onRefresh();
    }

    public void onRefresh() {

    }
}
