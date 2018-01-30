package wangfei.util.fragmentations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseF extends SwipeBackFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return attachToSwipeBack(getOnCreateView(inflater, container, savedInstanceState));
    }

    protected abstract View getOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
