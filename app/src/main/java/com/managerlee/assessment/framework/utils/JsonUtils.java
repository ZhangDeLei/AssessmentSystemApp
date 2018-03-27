package com.managerlee.assessment.framework.utils;

import com.google.gson.Gson;

/**
 * Created by anins on 2018/3/27.
 */

public class JsonUtils {
    public static final String toString(Object o) {
        return new Gson().toJson(o);
    }
}
