package wangfei.util.ble;

public interface OnBleWriteFileListener {
    void onWriteListener(int current, int total, int currentPercent);
}
