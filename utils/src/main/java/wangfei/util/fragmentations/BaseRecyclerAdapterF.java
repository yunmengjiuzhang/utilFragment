package wangfei.util.fragmentations;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecyclerAdapterF<V> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public BaseRecyclerAdapterF(List<V> list) {
        mValueList = list;
    }

    private List<V> mValueList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createNewViewHolder(parent, viewType);
    }

    protected abstract RecyclerView.ViewHolder createNewViewHolder(ViewGroup parent, int viewType);


    public ViewDataBinding getBinding(ViewGroup parent, int viewType) {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
    }


    @Override
    @SuppressWarnings("unchecked")//一定会是BaseViewHolder的子类，因为createViewHolder()的返回值
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseRecyclerFVH) holder).initDatas(mValueList, position);
        ((BaseRecyclerFVH) holder).getBinding().executePendingBindings();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mValueList == null ? 0 : mValueList.size();
    }
}