package com.timbercld.utils;

import com.timbercld.core.constant.Constant;

import java.util.Map;

public class QueryUtil {

    public static boolean isAsc(Map<String, Object> map) {
        if (map.containsKey(Constant.ORDER)) {
            if (map.get(Constant.ORDER).equals(Constant.ASC)) {
                return true;
            } else if (map.get(Constant.ORDER).equals(Constant.DESC)) {
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
