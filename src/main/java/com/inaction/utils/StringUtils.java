package com.inaction.utils;

public class StringUtils {
    
    /**
     * Trim the string.
     * @param str
     * @return - A string value without blank.
     */
    static String trimStr(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return str.trim();
    }
}
