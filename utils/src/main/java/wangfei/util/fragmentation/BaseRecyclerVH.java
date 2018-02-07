package wangfei.util.fragmentation;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class BaseRecyclerVH extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;
    protected BaseFragment mCtx;

    public BaseRecyclerVH(ViewDataBinding binding, BaseFragment ctx) {
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
