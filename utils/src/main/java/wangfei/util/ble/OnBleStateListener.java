package wangfei.util.ble;

/**
 * Created by fei on 2017/1/11.
 * 整个sdk的状态监听
 */
public interface OnBleStateListener {
//    void test(String s);

    /**
     * 0开头返回,表示通信完成,1开头表示通信前,数据检验时出错,2开头表示通信过程出错,
     */
    void state(int step);
}
