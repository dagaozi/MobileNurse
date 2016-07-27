package com.wyyy.corelibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/27 8:57
 * 类描述：Toast统一管理类
 */
public class ToastUtil {
    private static Toast toast = null;
    private static int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static int LENGTH_LONG = Toast.LENGTH_LONG;

    public static void showToast(Context context,String text)
    {
        Toast.makeText(context,text,LENGTH_SHORT).show();
    }
}
