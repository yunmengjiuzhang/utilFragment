package wangfei.util.ble;

import java.io.Serializable;

public class BleBean implements Serializable {
    public String name;
    public String address;
    public int rssi = 0;
    public byte[] mac = new byte[9];

    public BleBean(String name, String address, int rssi, byte[] mac) {
        this.name = name;
        this.address = address;
        this.rssi = rssi;
        this.mac = mac;
    }
}
