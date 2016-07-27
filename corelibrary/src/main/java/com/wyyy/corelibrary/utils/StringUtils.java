package com.wyyy.corelibrary.utils;

/**
 * Created by haohaibin .（dagaozi@163.com）
 * 创建时间：2016/7/26 15:37
 * 类描述：字符串工具
 */
public class StringUtils {
  /**
   *
   *Created by 郝海滨（dagaozi@163.com）
   *创建时间 2016/7/26 15:38
   *描述：查找字符村是否存在某字符
   */
    public static boolean isStringExist(String value, String subValue) {
        if (value.indexOf(subValue) > -1) {
            return true;
        }
        return false;
    }
   /**
    *
    *Created by 郝海滨（dagaozi@163.com）
    *创建时间 2016/7/26 15:38
    *描述：判断字符串是否为空
    */
    public static boolean isStrEmpty(String value) {
        if (null == value || "".equals(value.trim())) {
            return true;
        } else {
            // 判断是否全是全角空格
            value = value.replaceAll(" ", "").trim();
            if (null == value || "".equals(value.trim())) {
                return true;
            }
        }
        return false;
    }
/**
 *
 *Created by 郝海滨（dagaozi@163.com）
 *创建时间 2016/7/26 15:38
 *描述：判断对象是否为空
 */
    public static boolean isNotEmpty(Object object) {
        return null != object;
    }

}
