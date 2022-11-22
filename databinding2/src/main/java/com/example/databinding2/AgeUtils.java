package com.example.databinding2;

/**
 * @author AlexisYin
 */
public class AgeUtils {
    public static String getAge(int age) {
        if (age >= 12 && age <= 18) {
            return "青少年";
        }
        return "";
    }
}
