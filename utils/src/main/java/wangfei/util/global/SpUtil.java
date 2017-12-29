package wangfei.util.global;

import android.content.Context;
import android.content.SharedPreferences;

import wangfei.util.BaseApp;

/**
 * 存储临时变量
 */
public class SpUtil {

    private static String mFileName = "config";

    public static void init(String filename) {
        mFileName = filename;
    }

    private static SharedPreferences sp;

    /**
     * 写入boolean变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值 boolean
     */
    public static void putBoolean(String key, boolean value) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 读取boolean标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    public static boolean getBoolean(String key, boolean defValue) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    /**
     * 写入boolean变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值string
     */
    public static void putString(String key, String value) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 读取boolean标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    public static String getString(String key, String defValue) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 写入boolean变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值string
     */
    public static void putInt(String key, int value) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 读取boolean标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    public static int getInt(String key, int defValue) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }

//    /**
//     * 存储数据
//     *
//     * @param mContext 上下文
//     * @param tempName 存储名称
//     * @param tempList 数据集合
//     */
//    public static void setData( String tempName, List<?> tempList) {
////        SharedPreferences sps = mContext.getSharedPreferences("base64", Context.MODE_PRIVATE);
//        //(存储节点文件名称,读写方式)
//        if (sp == null) {
//            sp = UIUtils.getContext().getSharedPreferences("base64", Context.MODE_PRIVATE);
//        }
//
//        // 创建字节输出流
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            // 创建对象输出流，并封装字节流
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            // 将对象写入字节流
//            oos.writeObject(tempList);
//            // 将字节流编码成base64的字符串
//            String tempBase64 = Base64.encodeToString(baos.toByteArray(), 0);
////            String tempBase64 = new String(Base64.encodeBase64(baos.toByteArray()));
//            sp.edit().putString(tempName, tempBase64).commit();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (OutOfMemoryError e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<?> getData(Context mContext, String tempName) {
//        if (sp == null) {
//            sp = mContext.getSharedPreferences("base64", Context.MODE_PRIVATE);
//        }
////        SharedPreferences sps = mContext.getSharedPreferences("base64", Context.MODE_PRIVATE);
//        String tempBase64 = sp.getString(tempName, "");// 初值空
//        List<?> tempList = null;
//        if (tempBase64 == "") {
//            return tempList;
//        }
////        if (StringUtil.isBlank(tempBase64)) {
////            return tempList;
////        }
//
//        // 读取字节
//        byte[] base64 = Base64.decode(tempBase64.getBytes(), 0);
////        byte[] base64 = Base64.decodeBase64(tempBase64.getBytes());
//        // 封装到字节流
//        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
//        try {
//            // 再次封装
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            // 读取对象
//            tempList = (List<?>) ois.readObject();
//        } catch (StreamCorruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return tempList;
//    }

    /**
     * 从sp中移除指定节点
     *
     * @param key 需要移除节点的名称
     */

    public static void remove(String key) {
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        sp.edit().remove(key).commit();
    }

    /**
     * 清除所有缓存
     */
    public static void clear() {
        if (sp == null) {
            sp = BaseApp.getInstance().getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        }
        sp.edit().clear();
    }

//    /**
//     * encodeBase64File:(将文件转成base64 字符串). <br/>
//     *
//     * @param path 文件路径
//     */
//    public static String encodeBase64File(String path) throws Exception {
//        File file = new File(path);
//        FileInputStream inputFile = new FileInputStream(file);
//        byte[] buffer = new byte[(int) file.length()];
//        inputFile.read(buffer);
//        inputFile.close();
//        return Base64.encodeToString(buffer, Base64.DEFAULT);
//    }
//
//    /**
//     * decoderBase64File:(将base64字符解码保存文件).
//     *
//     * @param base64Code 编码后的字串
//     * @param savePath   文件保存路径
//     */
//    public static void decoderBase64File(String base64Code, String savePath) throws Exception {
////byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
//        byte[] buffer = Base64.decode(base64Code, Base64.DEFAULT);
//        FileOutputStream out = new FileOutputStream(savePath);
//        out.write(buffer);
//        out.close();
//    }
}
