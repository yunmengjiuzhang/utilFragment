package wangfei.util.fragmentations;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class BaseRecyclerFVH extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;
    protected BaseF mCtx;

    public BaseRecyclerFVH(ViewDataBinding binding, BaseF ctx) {
        super(binding.getRoot());
        this.binding = binding;
        mCtx = ctx;
    }

    public List mList;
    public int position;

    public void initDatas(List list, int position) {
        mList = list;
        this.position = position;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
