package com.managerlee.assessment.framework.utils;

/**
 * Created by anins on 2018/3/23.
 */

public class StringUtil {

    /**
     * 为空
     *
     * @param value
     * @return
     */
    public static boolean isNull(String value) {
        return value == null || "".equals(value) || "null".equals(value.toLowerCase());
    }

    /**
     * 不为空
     *
     * @param value
     * @return
     */
    public static boolean isNotNull(String value) {
        return !isNull(value);
    }
}
