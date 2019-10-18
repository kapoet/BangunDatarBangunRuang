package com.ervin.bangundatarbangunruang.ui;

public class Helper {
    public static double parseDoubleOrNull(String str) {
        double result = 0;
        try {
            result = Double.parseDouble(str);
        } catch (Exception e) {
        }
        return result;
    }
}
