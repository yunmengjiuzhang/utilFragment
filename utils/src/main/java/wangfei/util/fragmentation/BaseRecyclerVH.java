package wangfei.util.fragmentation;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class BaseRecyclerVH extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;
    protected SupportFragment mCtx;

    public BaseRecyclerVH(ViewDataBinding binding, SupportFragment ctx) {
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
