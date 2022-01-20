package ru.fmordashev.util;

import java.util.List;

public class StringUtils {

    public static boolean listContainsString(List<String> list, String targetString) {
        for (String s : list) {
            if (s.toLowerCase().contains(targetString.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    //коммент

    //коммент 2
}
