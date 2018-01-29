package wangfei.util.ble;

import java.util.ArrayList;

/**
 * Created by fei on 2017/1/11.
 * 搜索到的ble列表改变监听
 */
public interface OnBleScanListener {
    void OnNewBleBean(BleBean bean);

    void OnBleBeanList(ArrayList<BleBean> mScans);
}
