package wangfei.util.ble;

import android.bluetooth.BluetoothDevice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class BleTool {
    public static boolean containBytes(byte[] bytes, ArrayList<BleBean> arrlt) {
        if (arrlt == null)
            return false;
        for (BleBean bean : arrlt) {
            if (Arrays.equals(bean.mac, bytes))
                return true;
        }
        return false;
    }

    public static String getAddressFromMac(byte[] mac, ArrayList<BleBean> list) {
        for (BleBean bean : list) {
            if (Arrays.equals(mac, bean.mac))
                return bean.address;
        }
        return null;
    }

    public static byte[] macStr2Bytes(String outStr) {
        if (outStr.length() != 18)
            return null;
        int len = outStr.length() / 2;
        byte[] mac = new byte[len];
        for (int i = 0; i < len; i++) {
            String s = outStr.substring(i * 2, i * 2 + 2);
            if (Integer.valueOf(s, 16) > 0x7F) {
                mac[i] = (byte) (Integer.valueOf(s, 16) - 0xFF - 1);
            } else {
                mac[i] = Byte.valueOf(s, 16);
            }
        }
        return mac;
    }

    public static String macBytes2MasString(byte[] mac) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mac.length; i++) {
            if (mac[i] < 0)
                mac[i] += 256;
            sb.append(padLeft(Integer.toHexString(mac[i]), 2));
        }
        return sb.toString().toUpperCase();

    }

    private static String padLeft(String str, int len) {
        if (str.length() > 2)
            str = str.substring(str.length() - 2);
        String pad = "0000000000000000";
        return len > str.length() && len <= 16 && len >= 0 ? pad.substring(0, len - str.length()) + str : str;
    }

    public static boolean createBond(Class btClass, BluetoothDevice btDevice) throws Exception {
        Method createBondMethod = btClass.getMethod("createBond");
        Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }

    public static boolean removeBond(Class btClass, BluetoothDevice btDevice) throws Exception {
        Method removeBondMethod = btClass.getMethod("removeBond");
        Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);
        return returnValue.booleanValue();
    }

    public static String bytes16ToString(byte[] datas) {
        StringBuffer sb = new StringBuffer();
        char[] temp = new char[datas.length];
        for (int i = 0; i < datas.length; i++) {
            temp[i] = (char) datas[i];
            sb.append(temp[i]);
        }
        return sb.toString();
    }

    /**
     * 方便打印16进制字节数组，
     *
     * @param msg 16进制字节数组
     * @return 16进制字节数组的字符串
     */
    public static String bytes16ToHexStrings(byte[] msg) {
        StringBuffer s = new StringBuffer();
        String s1;
        for (int i = 0; i < msg.length; i++) {
            s1 = Integer.toHexString(((int) msg[i]));
            if (s1.length() <= 2) {
                s.append(s1);
            } else {
                s.append(s1.substring(s1.length() - 2));
            }
            s.append(",");
        }
        return String.valueOf(s);
    }
}
